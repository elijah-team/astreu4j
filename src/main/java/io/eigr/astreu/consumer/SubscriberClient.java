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
package io.eigr.astreu.consumer;

import akka.actor.*;
import akka.grpc.*;
import akka.grpc.internal.*;
import akka.grpc.javadsl.*;
import akka.stream.*;

import com.google.protobuf.*;
import io.grpc.*;

import scala.concurrent.*;

import static io.eigr.astreu.consumer.Subscriber.Serializers.*;


public abstract class SubscriberClient extends SubscriberClientPowerApi implements Subscriber, AkkaGrpcClient {
  public static final SubscriberClient create(GrpcClientSettings settings, ClassicActorSystemProvider sys) {
    return new DefaultSubscriberClient(settings, sys);
  }

  protected final static class DefaultSubscriberClient extends SubscriberClient {

      private final ClientState clientState;
      private final GrpcClientSettings settings;
      private final io.grpc.CallOptions options;
      private final Materializer mat;
      private final ExecutionContext ec;

      private DefaultSubscriberClient(GrpcClientSettings settings, ClassicActorSystemProvider sys) {
        this.settings = settings;
        this.mat = SystemMaterializer.get(sys).materializer();
        this.ec = sys.classicSystem().dispatcher();
        this.clientState = new ClientState(
          settings,
          akka.event.Logging$.MODULE$.apply(sys.classicSystem(), DefaultSubscriberClient.class, akka.event.LogSource$.MODULE$.<DefaultSubscriberClient>fromAnyClass()),
          sys);
        this.options = NettyClientUtils.callOptions(settings);

        sys.classicSystem().getWhenTerminated().whenComplete((v, e) -> close());
      }

  
    
      
        private final StreamResponseRequestBuilder<akka.stream.javadsl.Source<io.eigr.astreu.protocol.Message, akka.NotUsed>, io.eigr.astreu.protocol.Message> subscribeRequestBuilder(akka.grpc.internal.InternalChannel channel){
          return new JavaBidirectionalStreamingRequestBuilder<>(
                               subscribeDescriptor, channel, options, settings, ec);
        }
      
    
  
    
      private final SingleResponseRequestBuilder<io.eigr.astreu.protocol.Message, Empty> unsubscribeRequestBuilder(akka.grpc.internal.InternalChannel channel){
        return new JavaUnaryRequestBuilder<>(unsubscribeDescriptor, channel, options, settings, ec);
      }
    
  

      

        /**
         * For access to method metadata use the parameterless version of subscribe
         */
        public akka.stream.javadsl.Source<io.eigr.astreu.protocol.Message, akka.NotUsed> subscribe(akka.stream.javadsl.Source<io.eigr.astreu.protocol.Message, akka.NotUsed> request) {
          return subscribe().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer subscribe(io.eigr.astreu.protocol.Message) if possible.
         */
        
          public StreamResponseRequestBuilder<akka.stream.javadsl.Source<io.eigr.astreu.protocol.Message, akka.NotUsed>, io.eigr.astreu.protocol.Message> subscribe()
        
        {
          return subscribeRequestBuilder(clientState.internalChannel());
        }
      

        /**
         * For access to method metadata use the parameterless version of unsubscribe
         */
        public java.util.concurrent.CompletionStage<Empty> unsubscribe(io.eigr.astreu.protocol.Message request) {
          return unsubscribe().invoke(request);
        }

        /**
         * Lower level "lifted" version of the method, giving access to request metadata etc.
         * prefer unsubscribe(io.eigr.astreu.protocol.Message) if possible.
         */
        
          public SingleResponseRequestBuilder<io.eigr.astreu.protocol.Message, Empty> unsubscribe()
        
        {
          return unsubscribeRequestBuilder(clientState.internalChannel());
        }
      

      
        private static MethodDescriptor<io.eigr.astreu.protocol.Message, io.eigr.astreu.protocol.Message> subscribeDescriptor =
          MethodDescriptor.<io.eigr.astreu.protocol.Message, io.eigr.astreu.protocol.Message>newBuilder()
            .setType(
  
  
  
  MethodDescriptor.MethodType.BIDI_STREAMING 
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("astreu.core.protocol.consumer.Subscriber", "Subscribe"))
            .setRequestMarshaller(new ProtoMarshaller<io.eigr.astreu.protocol.Message>(MessageSerializer))
            .setResponseMarshaller(new ProtoMarshaller<io.eigr.astreu.protocol.Message>(MessageSerializer))
            .setSampledToLocalTracing(true)
            .build();
        
        private static MethodDescriptor<io.eigr.astreu.protocol.Message, Empty> unsubscribeDescriptor =
          MethodDescriptor.<io.eigr.astreu.protocol.Message, Empty>newBuilder()
            .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
            .setFullMethodName(MethodDescriptor.generateFullMethodName("astreu.core.protocol.consumer.Subscriber", "Unsubscribe"))
            .setRequestMarshaller(new ProtoMarshaller<io.eigr.astreu.protocol.Message>(MessageSerializer))
            .setResponseMarshaller(new ProtoMarshaller<Empty>(EmptySerializer))
            .setSampledToLocalTracing(true)
            .build();
        

      /**
       * Initiates a shutdown in which preexisting and new calls are cancelled.
       */
      public java.util.concurrent.CompletionStage<akka.Done> close() {
        return clientState.closeCS() ;
      }

     /**
      * Returns a CompletionState that completes successfully when shutdown via close()
      * or exceptionally if a connection can not be established after maxConnectionAttempts.
      */
      public java.util.concurrent.CompletionStage<akka.Done> closed() {
        return clientState.closedCS();
      }
  }

}



