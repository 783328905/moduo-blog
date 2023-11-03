package com.ctillnow.controller;

import com.ctillnow.netty.WebSocketHandler;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class ChatController {

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String handleMessage(String message) {
        return message;
    }


    @GetMapping("/txt")
    public void send(@RequestParam String username) throws IOException {
        Channel channel = WebSocketHandler.channelMap.get(username);
        ClassPathResource classPathResource = new ClassPathResource("application.yml");
        InputStream inputStream =classPathResource.getInputStream();
//        IOUtils.readLines(inputStream).forEach(channel::writeAndFlush);

        channel.writeAndFlush(new TextWebSocketFrame("12234334"));
        channel.writeAndFlush(new TextWebSocketFrame("testtttt"));
    }
}
