package com.example.newboot.netty.service;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ServerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildChannelHandler extends ChannelInitializer<Channel> {
    @Autowired
    private DiscardServerHandler discardServerHandler;

//    @Override
//    protected void initChannel(ServerChannel serverChannel) throws Exception {
//        serverChannel.pipeline().addLast(discardServerHandler);
//    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        channel.pipeline().addLast(discardServerHandler);
    }
}
