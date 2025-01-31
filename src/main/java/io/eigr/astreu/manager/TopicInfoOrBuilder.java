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
// source: astreu/core/protocol/manager/manager.proto

package io.eigr.astreu.manager;


import com.google.protobuf.*;


public interface TopicInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:astreu.core.protocol.manager.TopicInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>uint64 size = 2;</code>
   * @return The size.
   */
  long getSize();

  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  int getPropertiesCount();
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  boolean containsProperties(
      String key);
  /**
   * Use {@link #getPropertiesMap()} instead.
   */
  @Deprecated
  java.util.Map<String, String>
  getProperties();
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */
  java.util.Map<String, String>
  getPropertiesMap();
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */

  String getPropertiesOrDefault(
      String key,
      String defaultValue);
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */

  String getPropertiesOrThrow(
      String key);

  /**
   * <code>.google.protobuf.Timestamp createdAt = 4;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp createdAt = 4;</code>
   * @return The createdAt.
   */
  Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp createdAt = 4;</code>
   */
  TimestampOrBuilder getCreatedAtOrBuilder();
}
