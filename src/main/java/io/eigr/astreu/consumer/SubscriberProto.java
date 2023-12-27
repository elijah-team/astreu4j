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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: astreu/core/protocol/consumer/subscriber.proto

package io.eigr.astreu.consumer;


import com.google.protobuf.*;


public final class SubscriberProto {
  private SubscriberProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n.astreu/core/protocol/consumer/subscrib" +
      "er.proto\022\035astreu.core.protocol.consumer\032" +
      "#astreu/core/protocol/protocol.proto\032\033go" +
      "ogle/protobuf/empty.proto2\245\001\n\nSubscriber" +
      "\022O\n\tSubscribe\022\035.astreu.core.protocol.Mes" +
      "sage\032\035.astreu.core.protocol.Message\"\000(\0010" +
      "\001\022F\n\013Unsubscribe\022\035.astreu.core.protocol." +
      "Message\032\026.google.protobuf.Empty\"\000BH\n\027io." +
      "eigr.astreu.consumerB\017SubscriberProtoH\001P" +
      "\001\252\002\027Io.Eigr.Astreu.Consumerb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          io.eigr.astreu.protocol.ProtocolProto.getDescriptor(),
          EmptyProto.getDescriptor(),
        });
    io.eigr.astreu.protocol.ProtocolProto.getDescriptor();
    EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}