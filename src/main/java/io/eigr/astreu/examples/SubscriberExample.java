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
package io.eigr.astreu.examples;

import io.eigr.astreu.*;
import io.eigr.astreu.protocol.*;
import io.eigr.astreu.subscriber.*;
import org.reactivestreams.*;
import reactor.core.publisher.*;

class SubscriberExample {

    public static void main(final String[] args) {
        final Publisher<MessageWithContext> publisher =
                Astreu.at("127.0.0.1", 9980)
                        .asSub("test", "unique-subscription")

                        // You can use some filter options during receive messages
                        //.filter(msg -> true)
                        //.receiveOnly(MessageType.EXCHANGE)

                        //.bindWithThrottle(1, Duration.ofSeconds(1), 2);
                        .bind(); //This create a org.reactivestreams.Publisher

        // Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
        Flux.from(publisher).subscribe(messageWithContext -> {
            final AcknowledgeContext context = messageWithContext.getContext();

            //Messages can be of some types: [Exchange, Info, Failure]
            context.logger().debug("Message type is -> {}", messageWithContext.getType());
            // I am assuming it is an Exchange, but you should check this out before doing this here
            final Exchange message = messageWithContext.getMessage();

            context.logger().info("Incoming Message {}", message);

            //Request/Response pattern is supported
            /*context.reply(
                    Exchange.newBuilder()
                            .setUuid(UUID.randomUUID().toString())
                            .setMessage(
                                    Any.newBuilder()
                                    .setTypeUrl("your.custom.package.type/YourTypeHere")
                                    .setValue(ByteString.copyFrom("Hello I got your message".getBytes()))
                                    .build())
                            .build());
            */

            // Or simply confirm or reject the message
            context.accept(); // Send acknowledge or reject message with context.reject()
        });
    }
}
