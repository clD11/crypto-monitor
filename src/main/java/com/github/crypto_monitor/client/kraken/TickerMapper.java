package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.crypto_monitor.serialization.CustomSerializer;

import java.util.Map;

public class TickerMapper {

    private static final CustomSerializer customSerializer = new CustomSerializer();

    public Map<String, TickerInformation> mapToTickerInformation(KrakenResponseWrapper krakenResponseWrapper) throws JsonProcessingException {
        return customSerializer.readValue(krakenResponseWrapper.getResult(), new TypeReference<>(){});
    }

}