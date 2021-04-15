package com.example.newboot.client;

import com.example.newboot.netty.service.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoder extends ByteToMessageDecoder { // (1)
    /**
     * 使用ByteBuf
     * @param ctx
     * @param in
     * @param out
     */
//    @Override
//    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) { // (2)
//        if (in.readableBytes() < 4) {
//            return; // (3)
//        }
//
//        out.add(in.readBytes(4)); // (4)
//    }

    /**
     * 使用PoJo
     * @param ctx
     * @param in
     * @param out
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < 4) {
            return;
        }

        out.add(new UnixTime(in.readUnsignedInt()));
    }
}