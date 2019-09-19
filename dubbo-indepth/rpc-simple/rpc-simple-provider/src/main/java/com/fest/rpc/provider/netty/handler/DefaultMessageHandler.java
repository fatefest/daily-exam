package com.fest.rpc.provider.netty.handler;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: yesitao
 * @Date: 2019/6/20 10:10
 * @Description: 丢弃服务handler
 */
public class DefaultMessageHandler extends SimpleChannelInboundHandler {


    @Override
    public void handlerAdded(ChannelHandlerContext ctx){
        System.out.println(ctx.channel().remoteAddress()+"连接进来了!");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx){
        System.out.println(ctx.channel().remoteAddress()+"离开了！");
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        System.out.println("收到message："+o);
        ctx.channel().writeAndFlush("我收到消息了！");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println(ctx.channel().remoteAddress()+"断开了连接");
        ctx.close();
    }
}
