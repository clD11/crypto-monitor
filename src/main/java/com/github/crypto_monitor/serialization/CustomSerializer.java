package com.github.crypto_monitor.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public String asJsonString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public <T> T readValue(String jsonContent, Class<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(jsonContent, valueType);
    }

    public <T> T readValue(JsonNode jsonContent, TypeReference<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(jsonContent.toString(), valueType);
    }

    public JsonNode readTree(String content) throws JsonProcessingException {
        return objectMapper.readTree(content);
    }

}