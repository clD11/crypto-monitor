package com.github.crypto_monitor.aggregator.client.broadcaster;

import okhttp3.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BroadcasterWebSocketClient {

    private final WebSocket broadcasterWebSocket;

    @Autowired
    public BroadcasterWebSocketClient(@Qualifier("broadcasterWebSocket") WebSocket broadcasterWebSocket) {
        this.broadcasterWebSocket = broadcasterWebSocket;
    }

}