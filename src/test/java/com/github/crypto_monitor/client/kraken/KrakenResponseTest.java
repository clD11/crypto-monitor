package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class KrakenResponseTest {

    private static final String responseBody = "{\"error\":[],\"result\":{\"XXBTZUSD\":{" +
        "a\":[\"16333.60000\",\"9\",\"9.000\"],\"b\":[\"16333.50000\",\"1\",\"1.000\"]," +
        "c\":[\"16333.60000\",\"0.05300000\"]," +
        "v\":[\"15827.06927355\",\"18008.97560705\"]," +
        "p\":[\"17300.48804\",\"17480.91794\"]," +
        "t\":[80648,91848]," +
        "l\":[\"16210.00000\",\"16210.00000\"]," +
        "h\":[\"18900.00000\",\"19097.50000\"]," +
        "o\":\"18725.90000\"}}}";

    private final CustomSerializer customSerializer = new CustomSerializer();

    @Test
    void shouldSerializeKrakenResponse() throws JsonProcessingException {
        KrakenResponse actual = customSerializer.readValue(responseBody, KrakenResponse.class);
        assertThat(customSerializer.asJsonString(actual), is(responseBody));
    }
}