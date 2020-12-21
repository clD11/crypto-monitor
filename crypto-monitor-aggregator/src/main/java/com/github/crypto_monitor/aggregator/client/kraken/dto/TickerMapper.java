package com.github.crypto_monitor.aggregator.client.kraken.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.crypto_monitor.aggregator.serialization.CustomSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TickerMapper {

    private static final CustomSerializer customSerializer = new CustomSerializer();

    public Map<String, TickerInformation> mapToTickerInformation(KrakenResponseWrapper krakenResponseWrapper) throws JsonProcessingException {
        return customSerializer.readValue(krakenResponseWrapper.getResult(), new TypeReference<>(){});
    }

}