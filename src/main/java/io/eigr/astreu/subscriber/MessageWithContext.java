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

import io.eigr.astreu.*;
import io.eigr.astreu.protocol.*;

import java.util.*;

public final class MessageWithContext {
    private final Message            message;
    private final MessageType        type;
    private final AcknowledgeContext context;

    public MessageWithContext(MessageType type, AcknowledgeContext context, Message message) {
        this.type = type;
        this.context = context;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public <T> T getMessage() {
        Objects.requireNonNull(type, "Received invalid message type");

        switch (type) {
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

    public AcknowledgeContext getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "MessageWithContext{" +
                "type=" + type +
                ", message=" + message +
                ", context=" + context +
                '}';
    }
}
