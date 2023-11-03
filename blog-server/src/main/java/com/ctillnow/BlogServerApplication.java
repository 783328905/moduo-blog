package com.ctillnow;

import com.ctillnow.netty.NettyWebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class BlogServerApplication implements ApplicationRunner {

	@Autowired
	private NettyWebSocketServer nettyWebSocketServer;

	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		new Thread(nettyWebSocketServer).start();
	}
}
