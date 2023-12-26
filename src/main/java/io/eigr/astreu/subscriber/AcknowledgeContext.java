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

import akka.actor.typed.*;
import com.google.protobuf.*;

import io.eigr.astreu.*;
import io.eigr.astreu.protocol.*;
import io.eigr.astreu.protocol.Message;
import org.slf4j.*;

import reactor.core.publisher.*;

import java.time.*;
import java.util.*;

public final class AcknowledgeContext implements SubscriptionContext {

    private final String subscription;
    private final ActorSystem<Void> system;
    private final Optional<Exchange> exchange;
    private final EmitterProcessor<Message> stream;

    private ContextState state;

    public AcknowledgeContext(
            ActorSystem<Void> system, String subscription, Optional<Exchange> exchange, EmitterProcessor<Message> stream) {
        this.stream = stream;
        this.system = system;
        this.exchange = exchange;
        this.subscription = subscription;
        this.state  = ContextState.Initial;
        this.state = nextState();
    }

    @Override
    public void accept() {
        checkIfStateIsValid();

        if (exchange.isPresent()) {
            Instant time = Instant.now();
            stream.onNext(Message.newBuilder()
                    .setAck(
                            Ack.newBuilder()
                                    .setSubscription(subscription)
                                    .setReason(Ack.Reason.ACCEPT)
                                    .setUuid(UUID.randomUUID().toString())
                                    .setMetadata(createMetadata(time))
                                    .build())
                    .build());

            nextState();
        }
    }

    @Override
    public void reject() {
        checkIfStateIsValid();

        if (exchange.isPresent()) {
            Instant time = Instant.now();
            stream.onNext(Message.newBuilder()
                    .setAck(
                            Ack.newBuilder()
                                    .setSubscription(subscription)
                                    .setReason(Ack.Reason.REJECT)
                                    .setUuid(UUID.randomUUID().toString())
                                    .setMetadata(createMetadata(time))
                                    .build())
                    .build());

            nextState();
        }
    }

    @Override
    public void reply(Exchange message) throws NotMessageCorrelationException {
        checkIfStateIsValid();

        if (exchange.isPresent()) {
            Instant time = Instant.now();
            final Metadata metadata = message.getMetadata();
            final Metadata required = createMetadata(time);

            stream.onNext(Message.newBuilder()
                    .setExchange(message.toBuilder()
                            .setMetadata(
                                    metadata.toBuilder()
                                            .mergeFrom(required)
                                            .build()))
                    .build());

            nextState();
        } else {
            // Is it necessary to change the state of this context to Closed here?
            // For now I will keep the context open in this condition
            throw new NotMessageCorrelationException();
        }
    }

    @Override
    public Logger logger() {
        return this.system.log();
    }

    private Metadata createMetadata(Instant time) {
        Exchange exc = exchange.get();
        return Metadata.newBuilder()
                .setCorrelation(exc.getUuid())
                .setTopic(exc.getMetadata().getTopic())
                .setProducerId(exc.getMetadata().getProducerId())
                .putProperties(
                        SubscriptionContext.SOURCE_MESSAGE_TIME_NANOS,
                        String.valueOf(exc.getMetadata().getTimestamp().getNanos()))
                .putProperties(
                        SubscriptionContext.SOURCE_MESSAGE_TIME_SECONDS,
                        String.valueOf(exc.getMetadata().getTimestamp().getSeconds()))
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setNanos(time.getNano())
                                .setSeconds(time.getEpochSecond())
                                .build())
                .build();
    }

    private ContextState nextState() {
        this.state = state.nextState();
        return this.state;
    }

    private void checkIfStateIsValid() {
        if (!ContextState.Opened.equals(state) && !ContextState.Initial.equals(state)) {
            throw new IllegalStateException("Invalid state of this Context. State " + state);
        }
    }

    private enum ContextState {
        Initial {
            @Override
            public ContextState nextState() {
                return Opened;
            }
        },
        Opened {
            @Override
            public ContextState nextState() {
                return Closed;
            }
        },
        Closed {
            @Override
            public ContextState nextState() {
                return this;
            }
        };
        public abstract ContextState nextState();
    }
}
