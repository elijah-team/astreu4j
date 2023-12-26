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

// Generated by Akka gRPC. DO NOT EDIT.
package io.eigr.astreu.producer;

import akka.actor.*;
import akka.annotation.*;
import akka.grpc.*;
import akka.grpc.internal.*;
import akka.grpc.javadsl.*;
import akka.japi.function.*;
import akka.stream.*;

import java.util.*;
import java.util.concurrent.*;

import static io.eigr.astreu.producer.Publisher.Serializers.*;


/*
 * Generated by Akka gRPC. DO NOT EDIT.
 *
 * The API of this class may still change in future Akka gRPC versions, see for instance
 * https://github.com/akka/akka-grpc/issues/994
 */
@ApiMayChange
public class PublisherHandlerFactory {

    private static final CompletionStage<akka.http.javadsl.model.HttpResponse> notFound = CompletableFuture.completedFuture(
      akka.http.javadsl.model.HttpResponse.create().withStatus(akka.http.javadsl.model.StatusCodes.NOT_FOUND));

    private static final CompletionStage<akka.http.javadsl.model.HttpResponse> unsupportedMediaType = CompletableFuture.completedFuture(
      akka.http.javadsl.model.HttpResponse.create().withStatus(akka.http.javadsl.model.StatusCodes.UNSUPPORTED_MEDIA_TYPE));

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use {@link akka.grpc.javadsl.ServiceHandler#concatOrNotFound} with {@link PublisherHandlerFactory#partial} when combining
     * several services.
     */
    public static Function<akka.http.javadsl.model.HttpRequest, CompletionStage<akka.http.javadsl.model.HttpResponse>> create(Publisher implementation, ClassicActorSystemProvider system) {
      return create(implementation, Publisher.name, system);
    }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use {@link akka.grpc.javadsl.ServiceHandler#concatOrNotFound} with {@link PublisherHandlerFactory#partial} when combining
     * several services.
     */
    public static Function<akka.http.javadsl.model.HttpRequest, CompletionStage<akka.http.javadsl.model.HttpResponse>> create(Publisher implementation, akka.japi.Function<ActorSystem, akka.japi.Function<Throwable, Trailers>> eHandler, ClassicActorSystemProvider system) {
      return create(implementation, Publisher.name, eHandler, system);
    }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use {@link akka.grpc.javadsl.ServiceHandler#concatOrNotFound} with {@link PublisherHandlerFactory#partial} when combining
     * several services.
     *
     * Registering a gRPC service under a custom prefix is not widely supported and strongly discouraged by the specification.
     */
    public static Function<akka.http.javadsl.model.HttpRequest, CompletionStage<akka.http.javadsl.model.HttpResponse>> create(Publisher implementation, String prefix, ClassicActorSystemProvider system) {
      return partial(implementation, prefix, SystemMaterializer.get(system).materializer(), GrpcExceptionHandler.defaultMapper(), system);
    }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example `Http().bindAndHandleAsync`
     * for the generated partial function handler and ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use {@link akka.grpc.javadsl.ServiceHandler#concatOrNotFound} with {@link PublisherHandlerFactory#partial} when combining
     * several services.
     *
     * Registering a gRPC service under a custom prefix is not widely supported and strongly discouraged by the specification.
     */
    public static Function<akka.http.javadsl.model.HttpRequest, CompletionStage<akka.http.javadsl.model.HttpResponse>> create(Publisher implementation, String prefix, akka.japi.Function<ActorSystem, akka.japi.Function<Throwable, Trailers>> eHandler, ClassicActorSystemProvider system) {
      return partial(implementation, prefix, SystemMaterializer.get(system).materializer(), eHandler, system);
    }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example
     * `Http.get(system).bindAndHandleAsync`. It ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use {@link akka.grpc.javadsl.ServiceHandler#concatOrNotFound} when combining several services.
     */
    public static Function<akka.http.javadsl.model.HttpRequest, CompletionStage<akka.http.javadsl.model.HttpResponse>> partial(Publisher implementation, String prefix, ClassicActorSystemProvider system) {
      return partial(implementation, prefix, SystemMaterializer.get(system).materializer(), GrpcExceptionHandler.defaultMapper(), system);
    }

    /**
     * Creates a `HttpRequest` to `HttpResponse` handler that can be used in for example
     * `Http.get(system).bindAndHandleAsync`. It ends with `StatusCodes.NotFound` if the request is not matching.
     *
     * Use {@link akka.grpc.javadsl.ServiceHandler#concatOrNotFound} when combining several services.
     */
    public static Function<akka.http.javadsl.model.HttpRequest, CompletionStage<akka.http.javadsl.model.HttpResponse>> partial(Publisher implementation, String prefix, Materializer mat, akka.japi.Function<ActorSystem, akka.japi.Function<Throwable, Trailers>> eHandler, ClassicActorSystemProvider system) {
      TelemetrySpi spi = TelemetryExtension.get(system).spi();
      return (req -> {
        Iterator<String> segments = req.getUri().pathSegments().iterator();
        if (segments.hasNext() && segments.next().equals(prefix) && segments.hasNext()) {
          String method = segments.next();
          if (segments.hasNext()) return notFound; // we don't allow any random `/prefix/Method/anything/here
          else {
            return handle(spi.onRequest(prefix, method, req), method, implementation, mat, eHandler, system);
          }
        } else {
          return notFound;
        }
      });
    }

    public String getServiceName() {
      return Publisher.name;
    }

    private static CompletionStage<akka.http.javadsl.model.HttpResponse> handle(akka.http.javadsl.model.HttpRequest request, String method, Publisher implementation, Materializer mat, akka.japi.Function<ActorSystem, akka.japi.Function<Throwable, Trailers>> eHandler, ClassicActorSystemProvider system) {
      return GrpcMarshalling.negotiated(request, (reader, writer) -> {
        final CompletionStage<akka.http.javadsl.model.HttpResponse> response;
        
        switch(method) {
          
          case "Publish":
            response = GrpcMarshalling.unmarshalStream(request.entity().getDataBytes(), MessageSerializer, mat, reader)
              .thenApply(e -> implementation.publish(e))
              .thenApply(e -> GrpcMarshalling.marshalStream(e, MessageSerializer, writer, system, eHandler));
            break;
          
          default:
            CompletableFuture<akka.http.javadsl.model.HttpResponse> result = new CompletableFuture<>();
            result.completeExceptionally(new UnsupportedOperationException("Not implemented: " + method));
            response = result;
        }
        return response.exceptionally(e -> GrpcExceptionHandler.standard(e, eHandler, writer, system));
      })
      .orElseGet(() -> unsupportedMediaType);
    }
  }

