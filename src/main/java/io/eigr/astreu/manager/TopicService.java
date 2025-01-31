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
package io.eigr.astreu.manager;

import akka.grpc.*;
import akka.grpc.javadsl.*;

import com.google.protobuf.*;



public interface TopicService {
  
  
  java.util.concurrent.CompletionStage<TopicInfo> info(Topic in);
  
  
  java.util.concurrent.CompletionStage<Empty> drop(Topic in);
  
  
  java.util.concurrent.CompletionStage<TopicInfo> create(Topic in);
  

  static String name = "astreu.core.protocol.manager.TopicService";
  static akka.grpc.ServiceDescription description = new akka.grpc.internal.ServiceDescriptionImpl(name, ManagerProto.getDescriptor());

  public static class Serializers {
    
      public static ProtobufSerializer<Topic> TopicSerializer = new GoogleProtobufSerializer<>(Topic.class);
    
      public static ProtobufSerializer<TopicInfo> TopicInfoSerializer = new GoogleProtobufSerializer<>(TopicInfo.class);
    
      public static ProtobufSerializer<Empty> EmptySerializer = new GoogleProtobufSerializer<>(Empty.class);
    
  }
}
