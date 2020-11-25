package com.github.crypto_monitor.client.kraken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class KrakenClient {

    private static final String apiKraken ="https://api.kraken.com/O/public/";

    private static final OkHttpClient client = new OkHttpClient();

    public void ticker(List<TradingPair> tradingPairs) throws IOException {
        String pairs = "?pair=" + tradingPairs.stream().map(tradingPair -> tradingPair.getLhs() + tradingPair.getRhs())
                .collect(Collectors.joining(","));

        Request request = new Request.Builder()
                .url(apiKraken.concat(pairs))
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
    }
}
