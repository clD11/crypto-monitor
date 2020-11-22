package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = TradingPair.TradingPairBuilder.class)
public class TradingPair {

    private final String lhs;
    private final String rhs;

    public TradingPair(TradingPairBuilder builder) {
        this.lhs = builder.lhs;
        this.rhs = builder.rhs;
    }

    public String getLhs() {
        return lhs;
    }

    public String getRhs() {
        return rhs;
    }

    public static final class TradingPairBuilder {
        private String lhs;
        private String rhs;

        public static TradingPairBuilder builder() {
            return new TradingPairBuilder();
        }

        private TradingPairBuilder() {}

        public TradingPairBuilder withLhs(String lhs) {
            this.lhs = lhs;
            return this;
        }

        public TradingPairBuilder withRhs(String rhs) {
            this.rhs = rhs;
            return this;
        }

        public TradingPair build() {
            return new TradingPair(this);
        }
    }
}
