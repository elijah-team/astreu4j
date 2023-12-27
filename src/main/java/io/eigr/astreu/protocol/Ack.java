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
// source: astreu/core/protocol/protocol.proto

package io.eigr.astreu.protocol;

/**
 * <pre>
 * Ack is used for confirmation of sending or receiving messages.
 * When a customer connects and receives a message,
 * he must confirm receipt of the message by sending an 'Ack' message stating the reason for the confirmation.
 * Can be:
 *    ACCEPT:    When the message is received and probably successfully processed.
 *    REJECT:    When the message was received but it was probably not processed successfully.
 *               The message will be maintained by the Broker for a later delivery attempt.
 *              (Only when the publishing adapter is of the persistent type)
 *    KNOWLEDGE: Similar to the ACCEPT type but has slightly different semantics,
 *               meaning that no action should be taken between the parties.
 *               Used to exchange System messages or when the Broker wishes
 *               to inform the producer that the message has been forwarded for delivery.
 * Unlike other messaging systems Astreu will always inform the producer of the message
 * about the receipt of receipt from consumers. Thus giving more transparency and control
 * to producers about what actually happened with the message that was sent and when it happened.
 * </pre>
 *
 * Protobuf type {@code astreu.core.protocol.Ack}
 */
public  final class Ack extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:astreu.core.protocol.Ack)
    AckOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Ack.newBuilder() to construct.
  private Ack(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Ack() {
    uuid_ = "";
    reason_ = 0;
    subscription_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Ack();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Ack(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
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

            uuid_ = s;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            reason_ = rawValue;
            break;
          }
          case 26: {
            Metadata.Builder subBuilder = null;
            if (metadata_ != null) {
              subBuilder = metadata_.toBuilder();
            }
            metadata_ = input.readMessage(Metadata.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(metadata_);
              metadata_ = subBuilder.buildPartial();
            }

            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            subscription_ = s;
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
    return ProtocolProto.internal_static_astreu_core_protocol_Ack_descriptor;
  }

  @Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ProtocolProto.internal_static_astreu_core_protocol_Ack_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Ack.class, Builder.class);
  }

  /**
   * Protobuf enum {@code astreu.core.protocol.Ack.Reason}
   */
  public enum Reason
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>ACCEPT = 0;</code>
     */
    ACCEPT(0),
    /**
     * <code>REJECT = 1;</code>
     */
    REJECT(1),
    /**
     * <code>KNOWLEDGE = 2;</code>
     */
    KNOWLEDGE(2),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>ACCEPT = 0;</code>
     */
    public static final int ACCEPT_VALUE = 0;
    /**
     * <code>REJECT = 1;</code>
     */
    public static final int REJECT_VALUE = 1;
    /**
     * <code>KNOWLEDGE = 2;</code>
     */
    public static final int KNOWLEDGE_VALUE = 2;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @Deprecated
    public static Reason valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static Reason forNumber(int value) {
      switch (value) {
        case 0: return ACCEPT;
        case 1: return REJECT;
        case 2: return KNOWLEDGE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Reason>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Reason> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Reason>() {
            public Reason findValueByNumber(int number) {
              return Reason.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return Ack.getDescriptor().getEnumTypes().get(0);
    }

    private static final Reason[] VALUES = values();

    public static Reason valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Reason(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:astreu.core.protocol.Ack.Reason)
  }

  public static final int UUID_FIELD_NUMBER = 1;
  private volatile Object uuid_;
  /**
   * <pre>
   * Unique identifier of a ack message
   * </pre>
   *
   * <code>string uuid = 1;</code>
   * @return The uuid.
   */
  public String getUuid() {
    Object ref = uuid_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      uuid_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Unique identifier of a ack message
   * </pre>
   *
   * <code>string uuid = 1;</code>
   * @return The bytes for uuid.
   */
  public com.google.protobuf.ByteString
      getUuidBytes() {
    Object ref = uuid_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      uuid_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int REASON_FIELD_NUMBER = 2;
  private int reason_;
  /**
   * <pre>
   * Reason of the message confirmation
   * </pre>
   *
   * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
   * @return The enum numeric value on the wire for reason.
   */
  public int getReasonValue() {
    return reason_;
  }
  /**
   * <pre>
   * Reason of the message confirmation
   * </pre>
   *
   * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
   * @return The reason.
   */
  public Reason getReason() {
    @SuppressWarnings("deprecation")
    Reason result = Reason.valueOf(reason_);
    return result == null ? Reason.UNRECOGNIZED : result;
  }

  public static final int METADATA_FIELD_NUMBER = 3;
  private Metadata metadata_;
  /**
   * <pre>
   * Metadata. Must contain the original message uuid in the 'correlation' attribute
   * </pre>
   *
   * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
   * @return Whether the metadata field is set.
   */
  public boolean hasMetadata() {
    return metadata_ != null;
  }
  /**
   * <pre>
   * Metadata. Must contain the original message uuid in the 'correlation' attribute
   * </pre>
   *
   * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
   * @return The metadata.
   */
  public Metadata getMetadata() {
    return metadata_ == null ? Metadata.getDefaultInstance() : metadata_;
  }
  /**
   * <pre>
   * Metadata. Must contain the original message uuid in the 'correlation' attribute
   * </pre>
   *
   * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
   */
  public MetadataOrBuilder getMetadataOrBuilder() {
    return getMetadata();
  }

  public static final int SUBSCRIPTION_FIELD_NUMBER = 4;
  private volatile Object subscription_;
  /**
   * <pre>
   * Subscription identifier
   * </pre>
   *
   * <code>string subscription = 4;</code>
   * @return The subscription.
   */
  public String getSubscription() {
    Object ref = subscription_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      subscription_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Subscription identifier
   * </pre>
   *
   * <code>string subscription = 4;</code>
   * @return The bytes for subscription.
   */
  public com.google.protobuf.ByteString
      getSubscriptionBytes() {
    Object ref = subscription_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      subscription_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getUuidBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, uuid_);
    }
    if (reason_ != Reason.ACCEPT.getNumber()) {
      output.writeEnum(2, reason_);
    }
    if (metadata_ != null) {
      output.writeMessage(3, getMetadata());
    }
    if (!getSubscriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, subscription_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUuidBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, uuid_);
    }
    if (reason_ != Reason.ACCEPT.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, reason_);
    }
    if (metadata_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getMetadata());
    }
    if (!getSubscriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, subscription_);
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
    if (!(obj instanceof Ack)) {
      return super.equals(obj);
    }
    Ack other = (Ack) obj;

    if (!getUuid()
        .equals(other.getUuid())) return false;
    if (reason_ != other.reason_) return false;
    if (hasMetadata() != other.hasMetadata()) return false;
    if (hasMetadata()) {
      if (!getMetadata()
          .equals(other.getMetadata())) return false;
    }
    if (!getSubscription()
        .equals(other.getSubscription())) return false;
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
    hash = (37 * hash) + UUID_FIELD_NUMBER;
    hash = (53 * hash) + getUuid().hashCode();
    hash = (37 * hash) + REASON_FIELD_NUMBER;
    hash = (53 * hash) + reason_;
    if (hasMetadata()) {
      hash = (37 * hash) + METADATA_FIELD_NUMBER;
      hash = (53 * hash) + getMetadata().hashCode();
    }
    hash = (37 * hash) + SUBSCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getSubscription().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Ack parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Ack parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Ack parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Ack parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Ack parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Ack parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Ack parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Ack parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Ack parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Ack parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Ack parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Ack parseFrom(
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
  public static Builder newBuilder(Ack prototype) {
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
   * <pre>
   * Ack is used for confirmation of sending or receiving messages.
   * When a customer connects and receives a message,
   * he must confirm receipt of the message by sending an 'Ack' message stating the reason for the confirmation.
   * Can be:
   *    ACCEPT:    When the message is received and probably successfully processed.
   *    REJECT:    When the message was received but it was probably not processed successfully.
   *               The message will be maintained by the Broker for a later delivery attempt.
   *              (Only when the publishing adapter is of the persistent type)
   *    KNOWLEDGE: Similar to the ACCEPT type but has slightly different semantics,
   *               meaning that no action should be taken between the parties.
   *               Used to exchange System messages or when the Broker wishes
   *               to inform the producer that the message has been forwarded for delivery.
   * Unlike other messaging systems Astreu will always inform the producer of the message
   * about the receipt of receipt from consumers. Thus giving more transparency and control
   * to producers about what actually happened with the message that was sent and when it happened.
   * </pre>
   *
   * Protobuf type {@code astreu.core.protocol.Ack}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:astreu.core.protocol.Ack)
      AckOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ProtocolProto.internal_static_astreu_core_protocol_Ack_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ProtocolProto.internal_static_astreu_core_protocol_Ack_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Ack.class, Builder.class);
    }

    // Construct using io.eigr.astreu.protocol.Ack.newBuilder()
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
      uuid_ = "";

      reason_ = 0;

      if (metadataBuilder_ == null) {
        metadata_ = null;
      } else {
        metadata_ = null;
        metadataBuilder_ = null;
      }
      subscription_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ProtocolProto.internal_static_astreu_core_protocol_Ack_descriptor;
    }

    @Override
    public Ack getDefaultInstanceForType() {
      return Ack.getDefaultInstance();
    }

    @Override
    public Ack build() {
      Ack result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Ack buildPartial() {
      Ack result = new Ack(this);
      result.uuid_ = uuid_;
      result.reason_ = reason_;
      if (metadataBuilder_ == null) {
        result.metadata_ = metadata_;
      } else {
        result.metadata_ = metadataBuilder_.build();
      }
      result.subscription_ = subscription_;
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
      if (other instanceof Ack) {
        return mergeFrom((Ack)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Ack other) {
      if (other == Ack.getDefaultInstance()) return this;
      if (!other.getUuid().isEmpty()) {
        uuid_ = other.uuid_;
        onChanged();
      }
      if (other.reason_ != 0) {
        setReasonValue(other.getReasonValue());
      }
      if (other.hasMetadata()) {
        mergeMetadata(other.getMetadata());
      }
      if (!other.getSubscription().isEmpty()) {
        subscription_ = other.subscription_;
        onChanged();
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
      Ack parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Ack) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object uuid_ = "";
    /**
     * <pre>
     * Unique identifier of a ack message
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @return The uuid.
     */
    public String getUuid() {
      Object ref = uuid_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        uuid_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     * Unique identifier of a ack message
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @return The bytes for uuid.
     */
    public com.google.protobuf.ByteString
        getUuidBytes() {
      Object ref = uuid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        uuid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Unique identifier of a ack message
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @param value The uuid to set.
     * @return This builder for chaining.
     */
    public Builder setUuid(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      uuid_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Unique identifier of a ack message
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUuid() {
      
      uuid_ = getDefaultInstance().getUuid();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Unique identifier of a ack message
     * </pre>
     *
     * <code>string uuid = 1;</code>
     * @param value The bytes for uuid to set.
     * @return This builder for chaining.
     */
    public Builder setUuidBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      uuid_ = value;
      onChanged();
      return this;
    }

    private int reason_ = 0;
    /**
     * <pre>
     * Reason of the message confirmation
     * </pre>
     *
     * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
     * @return The enum numeric value on the wire for reason.
     */
    public int getReasonValue() {
      return reason_;
    }
    /**
     * <pre>
     * Reason of the message confirmation
     * </pre>
     *
     * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
     * @param value The enum numeric value on the wire for reason to set.
     * @return This builder for chaining.
     */
    public Builder setReasonValue(int value) {
      reason_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Reason of the message confirmation
     * </pre>
     *
     * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
     * @return The reason.
     */
    public Reason getReason() {
      @SuppressWarnings("deprecation")
      Reason result = Reason.valueOf(reason_);
      return result == null ? Reason.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Reason of the message confirmation
     * </pre>
     *
     * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
     * @param value The reason to set.
     * @return This builder for chaining.
     */
    public Builder setReason(Reason value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      reason_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Reason of the message confirmation
     * </pre>
     *
     * <code>.astreu.core.protocol.Ack.Reason reason = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearReason() {
      
      reason_ = 0;
      onChanged();
      return this;
    }

    private Metadata metadata_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Metadata, Metadata.Builder, MetadataOrBuilder> metadataBuilder_;
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     * @return Whether the metadata field is set.
     */
    public boolean hasMetadata() {
      return metadataBuilder_ != null || metadata_ != null;
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     * @return The metadata.
     */
    public Metadata getMetadata() {
      if (metadataBuilder_ == null) {
        return metadata_ == null ? Metadata.getDefaultInstance() : metadata_;
      } else {
        return metadataBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    public Builder setMetadata(Metadata value) {
      if (metadataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        metadata_ = value;
        onChanged();
      } else {
        metadataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    public Builder setMetadata(
        Metadata.Builder builderForValue) {
      if (metadataBuilder_ == null) {
        metadata_ = builderForValue.build();
        onChanged();
      } else {
        metadataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    public Builder mergeMetadata(Metadata value) {
      if (metadataBuilder_ == null) {
        if (metadata_ != null) {
          metadata_ =
            Metadata.newBuilder(metadata_).mergeFrom(value).buildPartial();
        } else {
          metadata_ = value;
        }
        onChanged();
      } else {
        metadataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    public Builder clearMetadata() {
      if (metadataBuilder_ == null) {
        metadata_ = null;
        onChanged();
      } else {
        metadata_ = null;
        metadataBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    public Metadata.Builder getMetadataBuilder() {
      
      onChanged();
      return getMetadataFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    public MetadataOrBuilder getMetadataOrBuilder() {
      if (metadataBuilder_ != null) {
        return metadataBuilder_.getMessageOrBuilder();
      } else {
        return metadata_ == null ?
            Metadata.getDefaultInstance() : metadata_;
      }
    }
    /**
     * <pre>
     * Metadata. Must contain the original message uuid in the 'correlation' attribute
     * </pre>
     *
     * <code>.astreu.core.protocol.Metadata metadata = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Metadata, Metadata.Builder, MetadataOrBuilder>
        getMetadataFieldBuilder() {
      if (metadataBuilder_ == null) {
        metadataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Metadata, Metadata.Builder, MetadataOrBuilder>(
                getMetadata(),
                getParentForChildren(),
                isClean());
        metadata_ = null;
      }
      return metadataBuilder_;
    }

    private Object subscription_ = "";
    /**
     * <pre>
     * Subscription identifier
     * </pre>
     *
     * <code>string subscription = 4;</code>
     * @return The subscription.
     */
    public String getSubscription() {
      Object ref = subscription_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        subscription_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <pre>
     * Subscription identifier
     * </pre>
     *
     * <code>string subscription = 4;</code>
     * @return The bytes for subscription.
     */
    public com.google.protobuf.ByteString
        getSubscriptionBytes() {
      Object ref = subscription_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        subscription_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Subscription identifier
     * </pre>
     *
     * <code>string subscription = 4;</code>
     * @param value The subscription to set.
     * @return This builder for chaining.
     */
    public Builder setSubscription(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      subscription_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Subscription identifier
     * </pre>
     *
     * <code>string subscription = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearSubscription() {
      
      subscription_ = getDefaultInstance().getSubscription();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Subscription identifier
     * </pre>
     *
     * <code>string subscription = 4;</code>
     * @param value The bytes for subscription to set.
     * @return This builder for chaining.
     */
    public Builder setSubscriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      subscription_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:astreu.core.protocol.Ack)
  }

  // @@protoc_insertion_point(class_scope:astreu.core.protocol.Ack)
  private static final Ack DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Ack();
  }

  public static Ack getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Ack>
      PARSER = new com.google.protobuf.AbstractParser<Ack>() {
    @Override
    public Ack parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Ack(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Ack> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Ack> getParserForType() {
    return PARSER;
  }

  @Override
  public Ack getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
