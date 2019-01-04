package com.issac.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(NettyClientApplication.class, args);

        // 建立连接并发送消息
        new NettyClient().sendData();
    }

}

