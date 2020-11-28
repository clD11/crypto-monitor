package com.github.crypto_monitor.web.resource;

import com.github.crypto_monitor.web.client.kraken.AssetPair;

import java.util.List;
import java.util.stream.Collectors;

public class PriceSentimentMapper {

    public List<AssetPair> mapToAssertPairs(List<String> assertPairs) {
        return assertPairs.stream()
                .map(pair -> AssetPair.AssetPairBuilder.builder()
                        .withLhs(pair.substring(0, 3))
                        .withRhs(pair.substring(3, 6))
                        .build())
                .collect(Collectors.toList());
    }

}