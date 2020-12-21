package com.github.crypto_monitor.aggregator.client.broadcaster;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.springframework.stereotype.Component;

@Component
public class BroadcasterWebSocketListener extends WebSocketListener {

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        System.out.println(response);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println("Received");
        System.out.println(text);
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
