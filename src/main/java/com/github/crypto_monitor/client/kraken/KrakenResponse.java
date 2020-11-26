package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = KrakenResponse.KrakenResponseBuilder.class)
public class KrakenResponse {

    @JsonProperty("result")
    private final JsonNode result;

    @JsonProperty("error")
    private final String[] error;

    public KrakenResponse(KrakenResponseBuilder builder) {
        this.result = builder.result;
        this.error = builder.error;
    }

    public JsonNode getResult() {
        return result;
    }

    public String[] getError() {
        return error;
    }

    public static final class KrakenResponseBuilder {
        private JsonNode result;
        private String[] error;

        private KrakenResponseBuilder(){}

        public static KrakenResponseBuilder builder() {
            return new KrakenResponseBuilder();
        }

        public KrakenResponseBuilder withResult(JsonNode result) {
            this.result = result;
            return this;
        }

        public KrakenResponseBuilder withError(String[] error) {
            this.error = error;
            return this;
        }

        public KrakenResponse build() {
            return new KrakenResponse(this);
        }
    }

}