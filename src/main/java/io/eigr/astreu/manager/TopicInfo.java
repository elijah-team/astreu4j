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


/**
 * Protobuf type {@code astreu.core.protocol.manager.TopicInfo}
 */
public  final class TopicInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:astreu.core.protocol.manager.TopicInfo)
    TopicInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TopicInfo.newBuilder() to construct.
  private TopicInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TopicInfo() {
    id_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new TopicInfo();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TopicInfo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 16: {

            size_ = input.readUInt64();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              properties_ = com.google.protobuf.MapField.newMapField(
                  PropertiesDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000001;
            }
            com.google.protobuf.MapEntry<String, String>
            properties__ = input.readMessage(
                PropertiesDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            properties_.getMutableMap().put(
                properties__.getKey(), properties__.getValue());
            break;
          }
          case 34: {
            Timestamp.Builder subBuilder = null;
            if (createdAt_ != null) {
              subBuilder = createdAt_.toBuilder();
            }
            createdAt_ = input.readMessage(Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(createdAt_);
              createdAt_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ManagerProto.internal_static_astreu_core_protocol_manager_TopicInfo_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetProperties();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ManagerProto.internal_static_astreu_core_protocol_manager_TopicInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            TopicInfo.class, Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private volatile Object id_;
  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  public String getId() {
    Object ref = id_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    Object ref = id_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SIZE_FIELD_NUMBER = 2;
  private long size_;
  /**
   * <code>uint64 size = 2;</code>
   * @return The size.
   */
  public long getSize() {
    return size_;
  }

  public static final int PROPERTIES_FIELD_NUMBER = 3;
  private static final class PropertiesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        String, String> defaultEntry =
            com.google.protobuf.MapEntry
            .<String, String>newDefaultInstance(
                ManagerProto.internal_static_astreu_core_protocol_manager_TopicInfo_PropertiesEntry_descriptor,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      String, String> properties_;
  private com.google.protobuf.MapField<String, String>
  internalGetProperties() {
    if (properties_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          PropertiesDefaultEntryHolder.defaultEntry);
    }
    return properties_;
  }

  public int getPropertiesCount() {
    return internalGetProperties().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */

  public boolean containsProperties(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    return internalGetProperties().getMap().containsKey(key);
  }
  /**
   * Use {@link #getPropertiesMap()} instead.
   */
  @Deprecated
  public java.util.Map<String, String> getProperties() {
    return getPropertiesMap();
  }
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */

  public java.util.Map<String, String> getPropertiesMap() {
    return internalGetProperties().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */

  public String getPropertiesOrDefault(
      String key,
      String defaultValue) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, String> map =
        internalGetProperties().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; properties = 3;</code>
   */

  public String getPropertiesOrThrow(
      String key) {
    if (key == null) { throw new NullPointerException(); }
    java.util.Map<String, String> map =
        internalGetProperties().getMap();
    if (!map.containsKey(key)) {
      throw new IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int       CREATEDAT_FIELD_NUMBER = 4;
  private             Timestamp createdAt_;
  /**
   * <code>.google.protobuf.Timestamp createdAt = 4;</code>
   * @return Whether the createdAt field is set.
   */
  public boolean hasCreatedAt() {
    return createdAt_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp createdAt = 4;</code>
   * @return The createdAt.
   */
  public Timestamp getCreatedAt() {
    return createdAt_ == null ? Timestamp.getDefaultInstance() : createdAt_;
  }
  /**
   * <code>.google.protobuf.Timestamp createdAt = 4;</code>
   */
  public TimestampOrBuilder getCreatedAtOrBuilder() {
    return getCreatedAt();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
    }
    if (size_ != 0L) {
      output.writeUInt64(2, size_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetProperties(),
        PropertiesDefaultEntryHolder.defaultEntry,
        3);
    if (createdAt_ != null) {
      output.writeMessage(4, getCreatedAt());
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
    }
    if (size_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, size_);
    }
    for (java.util.Map.Entry<String, String> entry
         : internalGetProperties().getMap().entrySet()) {
      com.google.protobuf.MapEntry<String, String>
      properties__ = PropertiesDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, properties__);
    }
    if (createdAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getCreatedAt());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof TopicInfo)) {
      return super.equals(obj);
    }
    TopicInfo other = (TopicInfo) obj;

    if (!getId()
        .equals(other.getId())) return false;
    if (getSize()
        != other.getSize()) return false;
    if (!internalGetProperties().equals(
        other.internalGetProperties())) return false;
    if (hasCreatedAt() != other.hasCreatedAt()) return false;
    if (hasCreatedAt()) {
      if (!getCreatedAt()
          .equals(other.getCreatedAt())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + SIZE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSize());
    if (!internalGetProperties().getMap().isEmpty()) {
      hash = (37 * hash) + PROPERTIES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetProperties().hashCode();
    }
    if (hasCreatedAt()) {
      hash = (37 * hash) + CREATEDAT_FIELD_NUMBER;
      hash = (53 * hash) + getCreatedAt().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static TopicInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static TopicInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static TopicInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static TopicInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static TopicInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static TopicInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static TopicInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static TopicInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static TopicInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static TopicInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static TopicInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static TopicInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(TopicInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code astreu.core.protocol.manager.TopicInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:astreu.core.protocol.manager.TopicInfo)
      TopicInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ManagerProto.internal_static_astreu_core_protocol_manager_TopicInfo_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetProperties();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetMutableProperties();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ManagerProto.internal_static_astreu_core_protocol_manager_TopicInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              TopicInfo.class, Builder.class);
    }

    // Construct using io.eigr.astreu.manager.TopicInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      id_ = "";

      size_ = 0L;

      internalGetMutableProperties().clear();
      if (createdAtBuilder_ == null) {
        createdAt_ = null;
      } else {
        createdAt_ = null;
        createdAtBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ManagerProto.internal_static_astreu_core_protocol_manager_TopicInfo_descriptor;
    }

    @Override
    public TopicInfo getDefaultInstanceForType() {
      return TopicInfo.getDefaultInstance();
    }

    @Override
    public TopicInfo build() {
      TopicInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public TopicInfo buildPartial() {
      TopicInfo result = new TopicInfo(this);
      int from_bitField0_ = bitField0_;
      result.id_ = id_;
      result.size_ = size_;
      result.properties_ = internalGetProperties();
      result.properties_.makeImmutable();
      if (createdAtBuilder_ == null) {
        result.createdAt_ = createdAt_;
      } else {
        result.createdAt_ = createdAtBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof TopicInfo) {
        return mergeFrom((TopicInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(TopicInfo other) {
      if (other == TopicInfo.getDefaultInstance()) return this;
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (other.getSize() != 0L) {
        setSize(other.getSize());
      }
      internalGetMutableProperties().mergeFrom(
          other.internalGetProperties());
      if (other.hasCreatedAt()) {
        mergeCreatedAt(other.getCreatedAt());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      TopicInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (TopicInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private Object id_ = "";
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public String getId() {
      Object ref = id_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 1;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private long size_ ;
    /**
     * <code>uint64 size = 2;</code>
     * @return The size.
     */
    public long getSize() {
      return size_;
    }
    /**
     * <code>uint64 size = 2;</code>
     * @param value The size to set.
     * @return This builder for chaining.
     */
    public Builder setSize(long value) {
      
      size_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 size = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSize() {
      
      size_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        String, String> properties_;
    private com.google.protobuf.MapField<String, String>
    internalGetProperties() {
      if (properties_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            PropertiesDefaultEntryHolder.defaultEntry);
      }
      return properties_;
    }
    private com.google.protobuf.MapField<String, String>
    internalGetMutableProperties() {
      onChanged();;
      if (properties_ == null) {
        properties_ = com.google.protobuf.MapField.newMapField(
            PropertiesDefaultEntryHolder.defaultEntry);
      }
      if (!properties_.isMutable()) {
        properties_ = properties_.copy();
      }
      return properties_;
    }

    public int getPropertiesCount() {
      return internalGetProperties().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */

    public boolean containsProperties(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      return internalGetProperties().getMap().containsKey(key);
    }
    /**
     * Use {@link #getPropertiesMap()} instead.
     */
    @Deprecated
    public java.util.Map<String, String> getProperties() {
      return getPropertiesMap();
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */

    public java.util.Map<String, String> getPropertiesMap() {
      return internalGetProperties().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */

    public String getPropertiesOrDefault(
        String key,
        String defaultValue) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetProperties().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */

    public String getPropertiesOrThrow(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      java.util.Map<String, String> map =
          internalGetProperties().getMap();
      if (!map.containsKey(key)) {
        throw new IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearProperties() {
      internalGetMutableProperties().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */

    public Builder removeProperties(
        String key) {
      if (key == null) { throw new NullPointerException(); }
      internalGetMutableProperties().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @Deprecated
    public java.util.Map<String, String>
    getMutableProperties() {
      return internalGetMutableProperties().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */
    public Builder putProperties(
        String key,
        String value) {
      if (key == null) { throw new NullPointerException(); }
      if (value == null) { throw new NullPointerException(); }
      internalGetMutableProperties().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; properties = 3;</code>
     */

    public Builder putAllProperties(
        java.util.Map<String, String> values) {
      internalGetMutableProperties().getMutableMap()
          .putAll(values);
      return this;
    }

    private Timestamp                                     createdAt_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     * @return Whether the createdAt field is set.
     */
    public boolean hasCreatedAt() {
      return createdAtBuilder_ != null || createdAt_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     * @return The createdAt.
     */
    public Timestamp getCreatedAt() {
      if (createdAtBuilder_ == null) {
        return createdAt_ == null ? Timestamp.getDefaultInstance() : createdAt_;
      } else {
        return createdAtBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    public Builder setCreatedAt(Timestamp value) {
      if (createdAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        createdAt_ = value;
        onChanged();
      } else {
        createdAtBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    public Builder setCreatedAt(
        Timestamp.Builder builderForValue) {
      if (createdAtBuilder_ == null) {
        createdAt_ = builderForValue.build();
        onChanged();
      } else {
        createdAtBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    public Builder mergeCreatedAt(Timestamp value) {
      if (createdAtBuilder_ == null) {
        if (createdAt_ != null) {
          createdAt_ =
            Timestamp.newBuilder(createdAt_).mergeFrom(value).buildPartial();
        } else {
          createdAt_ = value;
        }
        onChanged();
      } else {
        createdAtBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    public Builder clearCreatedAt() {
      if (createdAtBuilder_ == null) {
        createdAt_ = null;
        onChanged();
      } else {
        createdAt_ = null;
        createdAtBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    public Timestamp.Builder getCreatedAtBuilder() {
      
      onChanged();
      return getCreatedAtFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    public TimestampOrBuilder getCreatedAtOrBuilder() {
      if (createdAtBuilder_ != null) {
        return createdAtBuilder_.getMessageOrBuilder();
      } else {
        return createdAt_ == null ?
            Timestamp.getDefaultInstance() : createdAt_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp createdAt = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Timestamp, Timestamp.Builder, TimestampOrBuilder>
        getCreatedAtFieldBuilder() {
      if (createdAtBuilder_ == null) {
        createdAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Timestamp, Timestamp.Builder, TimestampOrBuilder>(
                getCreatedAt(),
                getParentForChildren(),
                isClean());
        createdAt_ = null;
      }
      return createdAtBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:astreu.core.protocol.manager.TopicInfo)
  }

  // @@protoc_insertion_point(class_scope:astreu.core.protocol.manager.TopicInfo)
  private static final TopicInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new TopicInfo();
  }

  public static TopicInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TopicInfo>
      PARSER = new com.google.protobuf.AbstractParser<TopicInfo>() {
    @Override
    public TopicInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TopicInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TopicInfo> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<TopicInfo> getParserForType() {
    return PARSER;
  }

  @Override
  public TopicInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

