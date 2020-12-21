package com.github.crypto_monitor.aggregator.client.kraken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.springframework.stereotype.Component;

@Component
public class KrakenClientWS {

    public void subscribe() throws InterruptedException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("ws://ws.kraken.com").build();
        KrakenWebSocketListener krakenWebSocketListener = new KrakenWebSocketListener();
        WebSocket webSocket = okHttpClient.newWebSocket(request, krakenWebSocketListener);
        Thread.sleep(120000);
        okHttpClient.dispatcher().executorService().shutdown();
    }

}
