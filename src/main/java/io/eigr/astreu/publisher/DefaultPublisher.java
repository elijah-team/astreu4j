/*-
 * =====LICENSE-START=====
 * Java 11 Application
 * ------
 * Copyright (C) 2020 - 2023 Organization Name
 * ------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * =====LICENSE-END=====
 */
package io.eigr.astreu.publisher;

import akka.*;
import akka.actor.typed.*;
import akka.grpc.*;
import akka.stream.javadsl.*;
import com.google.protobuf.*;

import io.eigr.astreu.*;
import io.eigr.astreu.producer.*;
import io.eigr.astreu.protocol.Message;
import io.eigr.astreu.protocol.System;
import io.eigr.astreu.protocol.*;

import org.reactivestreams.Publisher;
import reactor.core.publisher.*;

import java.time.*;
import java.util.*;

public final class DefaultPublisher implements Producer {
    private static final EmitterProcessor<Message> stream        = EmitterProcessor.create();
    private static final Source<Message, NotUsed>  requestStream = Source.fromPublisher(stream);

    private final String                   topic;
    private final Config                   config;
    private final String                   connectionId;
    private final PublisherClient          client;
    private final ActorSystem<Void>        system;
    private final Source<Message, NotUsed> responseStream;

    public DefaultPublisher(String topic, String connectionId, ActorSystem<Void> system, Config config) {
        this.topic = topic;
        this.system = system;
        this.config = config;
        this.connectionId = connectionId;
        this.client = getClient(system, config);
        this.responseStream = client.publish(requestStream);
    }

    @Override
    public Publisher<ReplyMessage> bind() {
        stream.onNext(
                Message.newBuilder()
                        .setSystem(createSystemMessage())
                        .build()
        );
        return responseStream
                .map(this::transform)
                .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), system);
    }

    @Override
    public void publish(Any message) {
        stream.onNext(creatMessage(getId(), message, new HashMap<>()));
    }

    @Override
    public void publish(Any message, Map<String, String> metadataProperties) {
        stream.onNext(creatMessage(getId(), message, metadataProperties));
    }

    @Override
    public void publish(String id, Any message) {
        stream.onNext(creatMessage(id, message, new HashMap<>()));
    }

    @Override
    public void publish(String id, Any message, Map<String, String> metadataProperties) {
        stream.onNext(creatMessage(id, message, metadataProperties));
    }

    public String getTopic() {
        return topic;
    }

    public Config getConfig() {
        return config;
    }

    public String getConnectionId() {
        return connectionId;
    }

    private PublisherClient getClient(ActorSystem<Void> system, Config config) {
        return PublisherClient.create(
                GrpcClientSettings.connectToServiceAt(config.getHost(), config.getPort(), system)
                        .withTls(config.getOptions().isUseTls()),
                system
        );
    }

    private Message creatMessage(String id, Any any, Map<String, String> metadataProperties) {
        Instant instant = Instant.now();
        return Message.newBuilder()
                .setExchange(
                        Exchange.newBuilder()
                                .setUuid(id)
                                .setMessage(any)
                                .setMetadata(
                                        Metadata.newBuilder()
                                                .putAllProperties(metadataProperties)
                                                .setTopic(this.topic)
                                                .setTimestamp(getTime(instant))
                                                .setProducerId(connectionId)
                                                .build()
                                )
                                .build()
                )
                .build();
    }

    private System createSystemMessage() {
        return System.newBuilder()
                .setConnect(
                        Connect.newBuilder()
                                .setTopic(topic)
                                .setUuid(connectionId)
                                .build()
                )
                .build();
    }

    private Timestamp getTime(Instant time) {
        return Timestamp.newBuilder()
                .setNanos(time.getNano())
                .setSeconds(time.getEpochSecond())
                .build();
    }

    private ReplyMessage transform(Message incoming) {
        return new ReplyMessage(system, incoming);
    }

    private String getId() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
