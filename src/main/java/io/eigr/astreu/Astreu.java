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
package io.eigr.astreu;

import akka.actor.typed.*;
import akka.actor.typed.javadsl.*;
import io.eigr.astreu.publisher.*;
import io.eigr.astreu.subscriber.*;

import java.util.*;

public final class Astreu {

    private final Config            config;
    private final ActorSystem<Void> system;

    private Astreu(Config config){
        this.config = config;
        this.system = ActorSystem.create(Behaviors.empty(), "AstreuSystem");
    }

    public static Astreu at(String host, int port) {
        Objects.requireNonNull(host, "Host not to be null");
        Objects.requireNonNull(port, "Port not to be null");
        return new Astreu(new Config(host, port, new ConnectionOptions()));
    }
    public static Astreu at(String host, int port, ConnectionOptions options) {
        Objects.requireNonNull(host, "Host not to be null");
        Objects.requireNonNull(port, "Port not to be null");
        Objects.requireNonNull(options, "Use at(host, port) if you not use ConnectionOptions argument");
        return new Astreu(new Config(host, port, options));
    }

    public Subscriber asSub(String topic, String subscription) {
        return new DefaultSubscriber(topic, subscription, system, config);
    }

    public Producer asPub(String topic, String connectionId) {
        return new DefaultPublisher(topic, connectionId, system, config);
    }
}
