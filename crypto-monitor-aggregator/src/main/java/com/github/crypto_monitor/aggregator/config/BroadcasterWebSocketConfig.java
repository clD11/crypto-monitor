package com.github.crypto_monitor.aggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration
public class BroadcasterWebSocketConfig {

    @Bean(name = "webSocketStompClient")
    public WebSocketStompClient webSocketStompClient() {
        return new WebSocketStompClient(new StandardWebSocketClient());
    }

}