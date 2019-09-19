package consumer.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: yesitao
 * @Date: 2019/6/20 17:06
 * @Description:
 */
public class ClientDefaultHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("客户端收到消息："+o);
    }
}
