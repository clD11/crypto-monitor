package com.github.crypto_monitor.aggregator.service;

import com.github.crypto_monitor.aggregator.client.broadcaster.BroadcasterClient;
import com.github.crypto_monitor.aggregator.client.kraken.AssetPair;
import com.github.crypto_monitor.aggregator.client.kraken.KrakenClient;
import com.github.crypto_monitor.aggregator.client.kraken.TickerInformation;
import com.github.crypto_monitor.aggregator.client.twitter.TwitterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class AggregationService {

    private final KrakenClient krakenClient;
    private final TwitterClient twitterClient;
    private final BroadcasterClient broadcasterClient;

    @Autowired
    public AggregationService(KrakenClient krakenClient, TwitterClient twitterClient, BroadcasterClient broadcasterClient) {
        this.krakenClient = krakenClient;
        this.twitterClient = twitterClient;
        this.broadcasterClient = broadcasterClient;
    }

    public Map<String, TickerInformation> getPriceSentiment(List<AssetPair> assetPairs) throws IOException {
        return krakenClient.ticker(assetPairs);
    }

}