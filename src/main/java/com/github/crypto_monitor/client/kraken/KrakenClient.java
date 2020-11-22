package com.github.crypto_monitor.client.kraken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class KrakenClient {

    private static final String apiKraken ="https://api.kraken.com/O/public/";

    private static final OkHttpClient client = new OkHttpClient();

    public void ticker(TickerRequestDto tickerRequestDto) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.kraken.com/0/public/Ticker?pair=XBTUSD")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            System.out.println(responseBody);
        }
    }
}
