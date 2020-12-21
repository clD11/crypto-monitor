package com.github.crypto_monitor.aggregator.config;

import com.github.crypto_monitor.aggregator.client.broadcaster.BroadcasterWebSocketListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BroadcasterConfig {

    @Bean(name = "broadcasterWebsocket")
    public WebSocket broadcasterWebsocket(@Value("${broadcaster.ws-root-url}") String broadcasterWsRootUrl,
                                          BroadcasterWebSocketListener broadcasterWebSocketListener) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(broadcasterWsRootUrl).build();
        return okHttpClient.newWebSocket(request, broadcasterWebSocketListener);
    }

}
