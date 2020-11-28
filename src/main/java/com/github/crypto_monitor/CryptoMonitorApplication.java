package com.github.crypto_monitor;

import com.github.crypto_monitor.client.kraken.KrakenClient;
import com.github.crypto_monitor.client.kraken.Pair;
import com.github.crypto_monitor.client.kraken.TickerInformation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CryptoMonitorApplication {

    private static final KrakenClient client = new KrakenClient();

    public static void main(String[] args) throws IOException {
        Pair XBTUSD = Pair.TradingPairBuilder.builder()
                .withLhs("XBT")
                .withRhs("USD")
                .build();

//        TradingPair ETHUSD = TradingPair.TradingPairBuilder.builder()
//                .withLhs("ETH")
//                .withRhs("USD")
//                .build();

        Map<String, TickerInformation> tickerInformation = client.ticker(List.of(XBTUSD));
    }

}
