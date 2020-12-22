package com.github.crypto_monitor.aggregator.client.broadcaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Component
public class BroadcasterWebSocketStompClient {

    private final WebSocketStompClient webSocketStompClient;

    @Autowired
    public BroadcasterWebSocketStompClient(@Qualifier("webSocketStompClient") WebSocketStompClient webSocketStompClient) {
        this.webSocketStompClient = webSocketStompClient;
    }

    public void send(String msg) {

    }
}