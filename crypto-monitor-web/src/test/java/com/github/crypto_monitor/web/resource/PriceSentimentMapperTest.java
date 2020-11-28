package com.github.crypto_monitor.web.resource;

import com.github.crypto_monitor.web.client.kraken.AssetPair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PriceSentimentMapperTest {

    private final PriceSentimentMapper priceSentimentMapper = new PriceSentimentMapper();

    @Test
    void shouldMapToAssertPair() {
        AssetPair expected1 = AssetPair.AssetPairBuilder.builder()
                .withLhs("XBT")
                .withRhs("ETH")
                .build();

        AssetPair expected2 = AssetPair.AssetPairBuilder.builder()
                .withLhs("YYY")
                .withRhs("ZZZ")
                .build();

        List<String> assertPairs = List.of(expected1, expected2).stream()
                .map(p -> p.getLhs() + p.getRhs())
                .collect(Collectors.toList());

        List<AssetPair> actual = priceSentimentMapper.mapToAssertPairs(assertPairs);

        assertAssertPair(actual.get(0), expected1);
        assertAssertPair(actual.get(1), expected2);
    }

    private void assertAssertPair(AssetPair actual, AssetPair expected) {
        assertThat(actual.getLhs(), is(expected.getLhs()));
        assertThat(actual.getRhs(), is(expected.getRhs()));
    }
}