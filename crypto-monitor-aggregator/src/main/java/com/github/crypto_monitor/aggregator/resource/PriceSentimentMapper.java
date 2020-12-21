package com.github.crypto_monitor.aggregator.resource;

import com.github.crypto_monitor.aggregator.client.kraken.AssetPair;
import com.github.crypto_monitor.aggregator.client.kraken.TickerInformation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PriceSentimentMapper {

    public List<AssetPair> mapToAssertPairs(List<String> assertPairs) {
        return assertPairs.stream()
                .map(pair -> AssetPair.AssetPairBuilder.builder()
                        .withLhs(pair.substring(0, 3))
                        .withRhs(pair.substring(3, 6))
                        .build())
                .collect(Collectors.toList());
    }

    public List<AssetPriceDto> mapToAssetPrice(Map<String, TickerInformation> assetPairTickerInformation) {
        List<AssetPriceDto> assetPriceDtos = new ArrayList<>();
        for (String key : assetPairTickerInformation.keySet()) {
            assetPriceDtos.add(AssetPriceDto.AssetPriceBuilder.builder()
                    .withAsset(key)
                    .withAskPrice(assetPairTickerInformation.get(key).getAsk()[0])
                    .withLocalDateTime(LocalDateTime.now())
                    .build()
            );
        }
        return assetPriceDtos;
    }
}