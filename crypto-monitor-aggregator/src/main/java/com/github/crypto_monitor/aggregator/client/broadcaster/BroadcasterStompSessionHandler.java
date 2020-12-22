package com.github.crypto_monitor.aggregator.client.broadcaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
public class BroadcasterStompSessionHandler extends StompSessionHandlerAdapter {

    private final String topic;
    private final String publish;

    @Autowired
    public BroadcasterStompSessionHandler(@Value("${broadcaster.tracker.topic}") String topic,
                                          @Value("${broadcaster.tracker.publish}") String publish) {
        this.topic = topic;
        this.publish = publish;
    }

    @Override
    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
        stompSession.subscribe(topic, this);
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {

    }

}
