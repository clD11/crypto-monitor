package com.github.crypto_monitor.web.service;

import com.github.crypto_monitor.web.client.kraken.AssetPair;
import com.github.crypto_monitor.web.client.kraken.KrakenClient;
import com.github.crypto_monitor.web.client.kraken.TickerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class PriceSentimentService {

    private final KrakenClient krakenClient;

    @Autowired
    public PriceSentimentService(KrakenClient krakenClient) {
        this.krakenClient = krakenClient;
    }

    public Map<String, TickerInformation> getPriceSentiment(List<AssetPair> assetPairs) throws IOException {
        return krakenClient.ticker(assetPairs);
    }

}