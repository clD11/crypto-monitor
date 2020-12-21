package com.github.crypto_monitor.aggregator.config;

import com.github.crypto_monitor.aggregator.client.kraken.KrakenWebSocketListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KrakenWebSocketConfig {

    @Bean(name = "krakenWebSocket")
    public WebSocket krakenWebSocket(@Value("${kraken.websocket.url}") String krakenWebSocketUrl,
                                     KrakenWebSocketListener krakenWebSocketListener ) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(krakenWebSocketUrl).build();
        return okHttpClient.newWebSocket(request, krakenWebSocketListener);
    }

}
