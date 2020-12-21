package com.github.crypto_monitor.aggregator.client.kraken;

import okhttp3.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class KrakenWebSocketClient {

    private final WebSocket krakenWebSocket;

    @Autowired
    public KrakenWebSocketClient(@Qualifier("krakenWebSocket") WebSocket krakenWebSocket) {
        this.krakenWebSocket = krakenWebSocket;
    }

    public void send(String message) {
        krakenWebSocket.send(message);
    }

}