package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String asJsonString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public <T> T readValue(String jsonContent, Class<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(jsonContent, valueType);
    }

}
