package com.github.crypto_monitor.client.kraken;

import com.github.crypto_monitor.serialization.CustomSerializer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KrakenClient {

    private static final String API_KRAKEN ="https://api.kraken.com/0/public/";

    private static final OkHttpClient client = new OkHttpClient();
    private static final CustomSerializer customSerializer = new CustomSerializer();

    private final TickerMapper tickerMapper = new TickerMapper();

    public Map<String, TickerInformation> ticker(List<Pair> tradingPairs) throws IOException {
        String pairs = "Ticker?pair=" + tradingPairs.stream().map(pair -> pair.getLhs() + pair.getRhs())
                .collect(Collectors.joining(","));

        Request request = new Request.Builder()
                .url(API_KRAKEN.concat(pairs))
                .build();

        KrakenResponseWrapper krakenResponseWrapper;
        try (Response response = client.newCall(request).execute()) {
            krakenResponseWrapper = customSerializer.readValue(response.body().string(),
                    KrakenResponseWrapper.class);
        }

        return tickerMapper.mapToTickerInformation(krakenResponseWrapper);
    }
}
