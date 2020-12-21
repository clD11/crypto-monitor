package com.github.crypto_monitor.aggregator.client.kraken.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = AssetPair.AssetPairBuilder.class)
public class AssetPair {

    private final String lhs;
    private final String rhs;

    public AssetPair(AssetPairBuilder builder) {
        this.lhs = builder.lhs;
        this.rhs = builder.rhs;
    }

    public String getLhs() {
        return lhs;
    }

    public String getRhs() {
        return rhs;
    }

    public static final class AssetPairBuilder {
        private String lhs;
        private String rhs;

        public static AssetPairBuilder builder() {
            return new AssetPairBuilder();
        }

        private AssetPairBuilder() {}

        public AssetPairBuilder withLhs(String lhs) {
            this.lhs = lhs;
            return this;
        }

        public AssetPairBuilder withRhs(String rhs) {
            this.rhs = rhs;
            return this;
        }

        public AssetPair build() {
            return new AssetPair(this);
        }
    }
}
