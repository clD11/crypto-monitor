package com.github.crypto_monitor.web.client.kraken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Component;

@Component
public class KrakenClientWS {

    public void subscribe() throws InterruptedException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("ws://ws.kraken.com").build();
        KrakenWebSocketListener krakenWebSocketListener = new KrakenWebSocketListener();
        okHttpClient.newWebSocket(request, krakenWebSocketListener);
        Thread.sleep(120000);
        okHttpClient.dispatcher().executorService().shutdown();
    }

}
