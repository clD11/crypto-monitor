package com.github.crypto_monitor.web.client.kraken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.crypto_monitor.web.serialization.CustomSerializer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class KrakenResponseWrapperTest {

    private static final String RESULT = "{\"key\":{\"key\":\"value\"}}";
    private static final String RESPONSE_BODY = "{\"error\":[],\"result\":" + RESULT + "}";
    private static final CustomSerializer customSerializer = new CustomSerializer();

    @Test
    void shouldSerializeKrakenResponseResultField() throws JsonProcessingException {
        JsonNode expected = customSerializer.readTree(RESULT);
        KrakenResponseWrapper actual = customSerializer.readValue(RESPONSE_BODY, KrakenResponseWrapper.class);
        assertThat(actual.getResult(), is(expected));
    }

    @Test
    void shouldSerializeKrakenResponseErrorField() throws JsonProcessingException {
        KrakenResponseWrapper actual = customSerializer.readValue(RESPONSE_BODY, KrakenResponseWrapper.class);
        assertThat(actual.getError(), is(new String[]{}));
    }
}