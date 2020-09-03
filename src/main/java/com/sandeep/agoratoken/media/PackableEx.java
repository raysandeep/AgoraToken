package com.sandeep.agoratoken.media;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}
