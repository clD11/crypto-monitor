package com.github.crypto_monitor.web.client.kraken;

import org.junit.jupiter.api.Test;

class KrakenClientWSTest {

    private final KrakenClientWS krakenClientWS = new KrakenClientWS();

    @Test
    void shouldStartKrakenWebSocketListener() throws InterruptedException {
        krakenClientWS.subscribe();
        System.out.println("ENDED");
    }

}