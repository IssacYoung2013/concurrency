package com.issac.client;

import com.issac.codec.MarshallingCodeCFactory;
import com.issac.entity.TranslatorData;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;


/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Slf4j
public class NettyClient {

    public static final String HOST = "127.0.0.1";

    public static final int PORT = 8765;

    private Channel channel; // 扩展完善 ConcurrentHashMap<KEY -> String,Value -> Channel> 池化

    private EventLoopGroup workGroup = new NioEventLoopGroup();

    private ChannelFuture cf;

    public NettyClient() {
        this.connect(HOST, PORT);
    }

    private void connect(String host, int port) {

        // 1. 创建一个工作线程组：用于实际处理业务的线程

        // 2. 辅助类注意client与server不一样
        Bootstrap bootstrap = new Bootstrap();

        // 绑定端口，同步等待请求连接
        try {
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    // 表示缓存区动态调配（自适应）
                    .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
                    // 缓冲区池化
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 二进制解码
                            socketChannel.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                            socketChannel.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                            socketChannel.pipeline().addLast(new ClientHandler());
                        }
                    });
            // 同步阻塞
            cf = bootstrap.connect(HOST, 8765).sync();
            log.info("Client connected...");

            // 接下来进行数据的发送：首先获取channel
            this.channel = cf.channel();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void sendData() {
        for (int i = 0; i < 10; i++) {
//            log.info("-------------" + this.channel);
            TranslatorData request = new TranslatorData();
            request.setId("" + i);
            request.setName("请求消息名称" + i);
            request.setMessage("请求消息内容" + i);
            this.channel.writeAndFlush(request);
        }
    }

    public void close() throws InterruptedException {

        cf.channel().closeFuture().sync();
//         优雅停机 数据发送完再停机
        workGroup.shutdownGracefully();
        log.info("Server Shutdown...");

    }
}
