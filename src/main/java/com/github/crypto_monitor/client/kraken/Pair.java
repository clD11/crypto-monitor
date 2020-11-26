package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Pair.TradingPairBuilder.class)
public class Pair {

    private final String lhs;
    private final String rhs;

    public Pair(TradingPairBuilder builder) {
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

        public Pair build() {
            return new Pair(this);
        }
    }
}
