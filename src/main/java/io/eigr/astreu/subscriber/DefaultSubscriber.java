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
package io.eigr.astreu.subscriber;

import akka.*;
import akka.actor.typed.*;
import akka.grpc.*;
import akka.stream.*;
import akka.stream.javadsl.*;
import io.eigr.astreu.Subscriber;
import io.eigr.astreu.*;
import io.eigr.astreu.consumer.*;
import io.eigr.astreu.protocol.System;
import io.eigr.astreu.protocol.*;
import org.reactivestreams.*;
import reactor.core.publisher.*;

import java.time.*;
import java.util.*;
import java.util.function.*;

public final class DefaultSubscriber implements Subscriber {
    private static final EmitterProcessor<Message> stream = EmitterProcessor.create();
    private static final Source<Message, NotUsed> requestStream = Source.fromPublisher(stream);

    private final String                   topic;
    private final Config                   config;
    private final String                   connectionId;
    private final String                   subscription;
    private final SubscriberClient         client;
    private final ActorSystem<Void>        system;
    private final Source<Message, NotUsed> responseStream;

    private Predicate<MessageWithContext> predicate   = null;
    private final List<MessageType>       filterTypes = new ArrayList<>();

    public DefaultSubscriber(String topic, String subscription, ActorSystem<Void> system, Config config) {
        Objects.requireNonNull(topic, "Topic is mandatory");
        Objects.requireNonNull(config, "Config not be null");
        Objects.requireNonNull(system, "ActorSystem not be null");
        Objects.requireNonNull(subscription, "Subscription is mandatory");
        this.topic = topic;
        this.system = system;
        this.config = config;
        this.subscription = subscription;
        this.client = getClient(system, config);
        this.responseStream = client.subscribe(requestStream);
        this.connectionId = UUID.randomUUID().toString().toLowerCase();
    }

    @Override
    public Publisher<MessageWithContext> bind() {
        stream.onNext(
                Message.newBuilder()
                        .setSystem(createSystemMessage())
                        .build()
        );
        return responseStream
                .map(this::createMessageWithContext)
                .filter(this::isAcceptable)
                .filter(this::applyFilter)
                .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), system);
    }

    @Override
    public Publisher<MessageWithContext> bindWithThrottle(int elements, Duration per, int maximumBurst) {
        stream.onNext(
                Message.newBuilder()
                        .setSystem(createSystemMessage())
                        .build()
        );
        return responseStream
                .throttle(elements, per, maximumBurst, (ThrottleMode) ThrottleMode.shaping())
                .map(this::createMessageWithContext)
                .filter(this::isAcceptable)
                .filter(this::applyFilter)
                .runWith(Sink.asPublisher(AsPublisher.WITH_FANOUT), system);
    }

    @Override
    public Subscriber receiveOnly(MessageType... types) {
        if (Objects.nonNull(types) && types.length > 0) {
            filterTypes.addAll(Arrays.asList(types));
        }
        return this;
    }

    @Override
    public Subscriber filter(Predicate<MessageWithContext> predicate) {
        this.predicate = predicate;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public String getSubscription() {
        return subscription;
    }

    private SubscriberClient getClient(ActorSystem<Void> system, Config config) {
        return SubscriberClient.create(
                GrpcClientSettings.connectToServiceAt(config.getHost(), config.getPort(), system)
                        .withTls(config.getOptions().isUseTls()),
                system
        );
    }

    private System createSystemMessage() {
        return System.newBuilder()
                .setConnect(
                        Connect.newBuilder()
                                .setTopic(topic)
                                .setSubscription(subscription)
                                .setUuid(connectionId)
                                .build()
                )
                .build();
    }

    private boolean isAcceptable(MessageWithContext msg) {
        return filterTypes.isEmpty() || filterTypes.contains(msg.getType());
    }

    private boolean applyFilter(MessageWithContext msg) {
        return Objects.isNull(this.predicate) || this.predicate.test(msg);
    }

    private MessageWithContext createMessageWithContext(Message incoming) {
        final Message.DataCase dataCase = incoming.getDataCase();
        Optional<Exchange> exchange = Optional.empty();
        MessageType        type     = null;
        switch (dataCase) {
            case EXCHANGE:
                type = MessageType.EXCHANGE;
                exchange = Optional.of(incoming.getExchange());
                system.log().debug("Exchange Message {}", exchange);
                break;
            case SYSTEM:
                final System sys = incoming.getSystem();
                system.log().debug("System Message {}", sys);

                switch (sys.getDataCase()) {
                    case INFO:
                        type = MessageType.INFO;
                        break;
                    case FAILURE:
                        type = MessageType.FAILURE;
                        break;
                    default:
                        type = null;
                }
                break;
            case ACK:
                type = MessageType.ACK;
                final Ack ack = incoming.getAck();
                system.log().debug("Ack Message {}", ack);
                break;
            case DATA_NOT_SET:
                system.log().warn("No Data Message!");
                break;
            default:
                // code block
        }
        return new MessageWithContext(
                type,
                new AcknowledgeContext(system, subscription, exchange, stream),
                incoming);
    }
}
