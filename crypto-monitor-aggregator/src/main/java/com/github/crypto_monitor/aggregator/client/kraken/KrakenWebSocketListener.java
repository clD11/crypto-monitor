package com.github.crypto_monitor.aggregator.client.kraken;

import com.github.crypto_monitor.aggregator.service.BasicQueue;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KrakenWebSocketListener extends WebSocketListener {

    private final BasicQueue basicQueue;

    @Autowired
    public KrakenWebSocketListener(BasicQueue basicQueue) {
        this.basicQueue = basicQueue;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        System.out.println("Connection Opened");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println("Received");
        System.out.println(text);
        basicQueue.add(text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString byteString) {
        System.out.println("Received Bytes");
        System.out.println(byteString.hex());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(1000, null);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        t.printStackTrace();
    }

}