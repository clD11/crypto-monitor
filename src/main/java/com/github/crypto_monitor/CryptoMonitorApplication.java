package com.github.crypto_monitor;

import com.github.crypto_monitor.client.kraken.KrakenClient;

import java.io.IOException;

public class CryptoMonitorApplication {

    private static final KrakenClient client = new KrakenClient();

    public static void main(String[] args) throws IOException {
        client.ticker(null);
    }

}
