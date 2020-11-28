package com.github.crypto_monitor.web;

import com.github.crypto_monitor.web.client.kraken.AssetPair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceSentimentResourceTest {

    private static final String URL = "https://api.kraken.com/0/public/";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldGetPriceSentiment() {
        AssetPair XBTUSD = AssetPair.AssetPairBuilder.builder()
                .withLhs("XBT")
                .withRhs("USD")
                .build();

        AssetPair ETHUSD = AssetPair.AssetPairBuilder.builder()
                .withLhs("ETH")
                .withRhs("USD")
                .build();

        String query = List.of(XBTUSD, ETHUSD).stream()
                .map(pair -> "" + pair.getLhs() + pair.getRhs())
                .collect(Collectors.joining(","));

        String url = String.format("http://localhost:%d/api/v1/price-sentiment?assetpairs=%s", port, query);

        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

}