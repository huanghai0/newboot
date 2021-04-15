package com.example.newboot.netty.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ChannelHandler.Sharable
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    private BaseService baseService;

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//
//        try {
//            ByteBuf in = (ByteBuf) msg;
//            System.out.println("msg传输内容是");
//            System.out.println(in.toString(CharsetUtil.UTF_8));
//            //这里调用service服务
//            baseService.test();
//
////            ctx.channel().writeAndFlush(new TextWebSocketFrame("I am channel active"));
//            //返回给客户端的信息
////            ByteBuf result = Unpooled.copiedBuffer("I am channel active".getBytes());
////            ctx.writeAndFlush(result);
//
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }


//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//
//        final ByteBuf time = ctx.alloc().buffer(4); // (2)
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
//
////        ByteBuf result = Unpooled.copiedBuffer("I am channel active".getBytes());
////        final ChannelFuture f = ctx.writeAndFlush(result);
//        f.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                assert f == future;
////                ctx.close();
//
//            }
//        }); // (4)
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }

}
