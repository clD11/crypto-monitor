package com.github.crypto_monitor.aggregator.client.broadcaster;

import okhttp3.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BroadcasterClient {

    private final WebSocket broadcasterWebsocket;

    @Autowired
    public BroadcasterClient(@Qualifier("broadcasterWebsocket") WebSocket broadcasterWebsocket) {
        this.broadcasterWebsocket = broadcasterWebsocket;
    }

    public void updateTracker(String update) {
        broadcasterWebsocket.send(update);
    }

}
