package com.github.crypto_monitor.web.client.kraken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.crypto_monitor.web.serialization.CustomSerializer;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class TickerInformationTest {

    private static final CustomSerializer customSerializer = new CustomSerializer();

    @Test
    void shouldDeserializeTickerInformation() throws JsonProcessingException {
        TickerInformation expected = TickerInformation.TickerDtoBuilder.builder()
                .withAsk(new String[] { "16333.60000", "9","9.000" })
                .withBid(new String[] { "16333.50000", "1", "1.000" })
                .withLastTradeClosed(new String[] { "16333.60000", "0.05300000" })
                .withVolume(new String[] { "15827.06927355", "18008.97560705" })
                .withNumberOfTrades(new String[] { "17300.48804", "17480.91794" })
                .withLow(new String[] { "80648,91848" })
                .withHigh(new String[] { "16210.00000", "16210.00000" })
                .withTodaysOpenPrice("18725.90000")
                .build();
        String input = customSerializer.asJsonString(expected);
        TickerInformation actual = customSerializer.readValue(input, TickerInformation.class);
        assertThat(actual, CoreMatchers.is(expected));
    }
}