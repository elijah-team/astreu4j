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
package tripleo.samples.io.eigr.astreu.examples;

import com.google.protobuf.*;
import io.eigr.astreu.*;
import io.eigr.astreu.protocol.*;
import io.eigr.astreu.publisher.*;
import org.junit.jupiter.api.*;
import org.reactivestreams.*;
import org.slf4j.*;
import reactor.core.publisher.*;

import java.time.*;
import java.time.Duration;
import java.util.*;
import java.util.stream.*;

class ProducerExampleTest {

	private static Publisher<ReplyMessage> getPublisher(final Producer producer) {
		final Publisher<ReplyMessage> publisher = producer.bind(); //This create a org.reactivestreams.Publisher
		return publisher;
	}

	private static Producer getProducer() {
		final Producer producer =
				Astreu.at("127.0.0.1", 9980)
						.asPub("test", UUID.randomUUID().toString().toLowerCase());
		return producer;
	}

	private byte[] b(final int i) {
		final String s = String.format("Hello World Astreu %s", i);
		return s.getBytes();
	}

	private void computeRtt(Logger logger, Metadata metadata) {
		final Map<String, String> properties = metadata.getPropertiesMap();
		if (properties.containsKey("source-time-seconds")) {
			long          seconds       = Long.valueOf(properties.get("source-time-seconds"));
			final Instant sourceInstant = Instant.ofEpochSecond(seconds);
			logger.info("Total RTT between send Message [{}] and Receive ACK in millis [{}]",
					metadata.getCorrelation(),
					Duration.between(sourceInstant, Instant.now()).toMillis());
		}
	}

	@Test
	public void producerExampleTest() {
		final Producer producer = getProducer();

		final Publisher<ReplyMessage> publisher = getPublisher(producer);

		// Then use with any Reactive Streams framework (build-in with Project Reactor or Akka)
		Flux.from(publisher).subscribe(replyMessage -> {
			//Messages can be of some types: [Ack, Exchange, Info, Failure]
			Metadata metadata;
			int      y = 2;
			switch (replyMessage.getType()) {
				case ACK:
					Ack ack = replyMessage.getMessage();
					metadata = ack.getMetadata();
					computeRtt(replyMessage.logger(), metadata);
					break;
				case EXCHANGE:
					Exchange exchange = replyMessage.getMessage();
					metadata = exchange.getMetadata();
					computeRtt(replyMessage.logger(), metadata);
					break;
				case FAILURE:
				case INFO:
					break;
			}

			replyMessage.logger().info("Reply Message -> {}", replyMessage);
		});

		IntStream.range(0, 2).parallel().forEach(i -> {
			producer.publish(
					String.valueOf(i), //id of a message or use producer.publish(any) For automatic creation of UUID-based ids
					Any.newBuilder()
							.setTypeUrl("io.astreu.custom/Text")
							.setValue(ByteString.copyFrom(b(i)))
							.build()
			);
		});
	}
}
