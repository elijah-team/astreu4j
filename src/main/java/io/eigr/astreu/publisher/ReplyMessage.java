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

import akka.actor.typed.*;
import io.eigr.astreu.*;
import io.eigr.astreu.protocol.System;
import io.eigr.astreu.protocol.*;
import org.slf4j.*;

import java.util.*;

public final class ReplyMessage implements PublisherContext {

    private       MessageType       type;
    private final Message           message;
    private final ActorSystem<Void> system;

    public ReplyMessage(ActorSystem<Void> system, Message message) {
        this.system = system;
        this.message = message;
        setType(message);
    }

    public MessageType getType() {
        return type;
    }

    public <T> T getMessage() {
        Objects.requireNonNull(type, "Received invalid message type");

        switch (type) {
            case ACK:
                return (T) this.message.getAck();
            case EXCHANGE:
                return (T) this.message.getExchange();
            case INFO:
                return (T) this.message.getSystem().getInfo();
            case FAILURE:
                return (T) this.message.getSystem().getFailure();
            default:
                throw new IllegalStateException("Received invalid message type");
        }
    }

    @Override
    public Logger logger() {
        return this.system.log();
    }

    private void setType(Message message) {
        final Message.DataCase dataCase = message.getDataCase();
        switch (dataCase) {
            case EXCHANGE:
                this.type = MessageType.EXCHANGE;
                break;
            case SYSTEM:
                final System sys = message.getSystem();
                switch (sys.getDataCase()) {
                    case INFO:
                        type = MessageType.INFO;
                        break;
                    case FAILURE:
                        type = MessageType.FAILURE;
                        break;
                    default:
                        throw new IllegalStateException("Received invalid message type");
                }
                break;
            case ACK:
                type = MessageType.ACK;
                break;
            case DATA_NOT_SET:
                break;
            default:
                throw new IllegalStateException("Received invalid message type");
        }
    }

    @Override
    public String toString() {
        return "ReplyMessage{" +
                "type=" + type +
                ", message=" + message +
                '}';
    }
}
