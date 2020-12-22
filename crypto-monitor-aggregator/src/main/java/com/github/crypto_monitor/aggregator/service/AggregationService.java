package com.github.crypto_monitor.aggregator.service;

import com.github.crypto_monitor.aggregator.client.broadcaster.BroadcasterWebSocketStompClient;
import com.github.crypto_monitor.aggregator.client.kraken.KrakenWebSocketClient;
import com.github.crypto_monitor.aggregator.client.twitter.TwitterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class AggregationService {

    private static final String EVENT = "{\n" +
            "  \"event\": \"subscribe\",\n" +
            "  \"pair\": [\n" +
            "    \"XBT/USD\",\n" +
            "    \"XBT/EUR\"\n" +
            "  ],\n" +
            "  \"subscription\": {\n" +
            "    \"name\": \"ticker\"\n" +
            "  }\n" +
            "}";

    private static final AtomicBoolean run = new AtomicBoolean(false);

    private final KrakenWebSocketClient krakenWebSocketClient;
    private final TwitterClient twitterClient;
    private final BroadcasterWebSocketStompClient broadcasterWebSocketStompClient;
    private final BasicQueue basicQueue;

    @Autowired
    public AggregationService(KrakenWebSocketClient krakenWebSocketClient, TwitterClient twitterClient,
                              BroadcasterWebSocketStompClient broadcasterWebSocketStompClient, BasicQueue basicQueue) {
        this.krakenWebSocketClient = krakenWebSocketClient;
        this.twitterClient = twitterClient;
        this.broadcasterWebSocketStompClient = broadcasterWebSocketStompClient;
        this.basicQueue = basicQueue;
    }

    public void start() {
        krakenWebSocketClient.send(EVENT);
        run.compareAndExchange(false, true);

        while (run.get()) {
            //broadcasterWebSocketStompClient.(basicQueue.take());
        }
    }

    public void stop() {
        run.compareAndExchange(true, false);
    }

}