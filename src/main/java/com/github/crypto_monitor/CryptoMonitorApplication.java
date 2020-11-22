package com.github.crypto_monitor;

import com.github.crypto_monitor.client.kraken.KrakenClient;
import com.github.crypto_monitor.client.kraken.TradingPair;

import java.io.IOException;
import java.util.List;

public class CryptoMonitorApplication {

    private static final KrakenClient client = new KrakenClient();

    public static void main(String[] args) throws IOException {
        TradingPair XBTUSD = TradingPair.TradingPairBuilder.builder()
                .withLhs("XBT")
                .withRhs("USD")
                .build();

        TradingPair ETHUSD = TradingPair.TradingPairBuilder.builder()
                .withLhs("ETH")
                .withRhs("USD")
                .build();

        client.ticker(List.of(XBTUSD, ETHUSD));
    }

}
