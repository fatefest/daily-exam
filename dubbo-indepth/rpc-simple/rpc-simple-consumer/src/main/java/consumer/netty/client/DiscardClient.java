package consumer.netty.client;

import consumer.netty.handler.ClientDefaultHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.*;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: yesitao
 * @Date: 2019/6/20 10:45
 * @Description:
 */
public class DiscardClient{
    Channel channel;
    String host;
    int port;

    public DiscardClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void connect(){
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
//                    ch.pipeline().addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
//                    ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                    ch.pipeline().addLast(new StringEncoder());
//                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new LengthFieldPrepender(2));
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new ClientDefaultHandler());
                }
            });
            // Start the client.
            this.channel = b.connect(host, port).sync().channel();

            channel.closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public void send(Object message){
        this.channel.writeAndFlush(message);
    }

    public static void main(String[] args) {
        DiscardClient discardClient = new DiscardClient("127.0.0.1",8088);
        discardClient.connect();
        discardClient.send("我开始了！！");
    }
}
