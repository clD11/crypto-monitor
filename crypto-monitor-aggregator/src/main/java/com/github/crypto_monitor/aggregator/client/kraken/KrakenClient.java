package com.github.crypto_monitor.aggregator.client.kraken;

import com.github.crypto_monitor.aggregator.config.KrakenClientConfig;
import com.github.crypto_monitor.aggregator.serialization.CustomSerializer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class KrakenClient {

    private static final OkHttpClient client = new OkHttpClient();

    private final KrakenClientConfig krakenClientConfig;
    private final CustomSerializer customSerializer;
    private final TickerMapper tickerMapper;

    @Autowired
    public KrakenClient(KrakenClientConfig krakenClientConfig, CustomSerializer customSerializer,
                        TickerMapper tickerMapper) {
        this.krakenClientConfig = krakenClientConfig;
        this.customSerializer = customSerializer;
        this.tickerMapper = tickerMapper;
    }

    public Map<String, TickerInformation> ticker(List<AssetPair> tradingAssetPairs) throws IOException {
        String pairs = "Ticker?pair=" + tradingAssetPairs.stream().map(tradingPair -> tradingPair.getLhs() + tradingPair.getRhs())
                .collect(Collectors.joining(","));

        Request request = new Request.Builder()
                .url(krakenClientConfig.getRootUrl().concat(pairs))
                .build();

        KrakenResponseWrapper krakenResponseWrapper;
        try (Response response = client.newCall(request).execute()) {
            krakenResponseWrapper = customSerializer.readValue(response.body().string(),
                    KrakenResponseWrapper.class);
            if (krakenResponseWrapper.getError().length > 0) {
                throw new IOException();
            }
        }

        return tickerMapper.mapToTickerInformation(krakenResponseWrapper);
    }
}
