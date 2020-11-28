package com.github.crypto_monitor.web.client.kraken;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = KrakenResponseWrapper.KrakenResponseBuilder.class)
public class KrakenResponseWrapper {

    @JsonProperty("result")
    private final JsonNode result;

    @JsonProperty("error")
    private final String[] error;

    public KrakenResponseWrapper(KrakenResponseBuilder builder) {
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

        public KrakenResponseWrapper build() {
            return new KrakenResponseWrapper(this);
        }
    }

}