package com.github.crypto_monitor.web.client.kraken;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class KrakenWebSocketListener extends WebSocketListener {

    private final String payload = "{\n" +
            "  \"event\": \"subscribe\",\n" +
            "  \"pair\": [\n" +
            "    \"XBT/USD\",\n" +
            "    \"XBT/EUR\"\n" +
            "  ],\n" +
            "  \"subscription\": {\n" +
            "    \"name\": \"ticker\"\n" +
            "  }\n" +
            "}";

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.send(payload);
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