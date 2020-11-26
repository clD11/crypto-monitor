package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(builder = TradingPair.TradingPairBuilder.class)
public class TradingPair {

    private final String pair;
    private final List<TickerInformation> tickerInformation;

    public TradingPair(TradingPairBuilder builder) {
        this.pair = builder.pair;
        this.tickerInformation = builder.tickerInformation;
    }

    public String getPair() {
        return pair;
    }

    public List<TickerInformation> getTickerInformation() {
        return tickerInformation;
    }

    public static final class TradingPairBuilder {
        private String pair;
        private List<TickerInformation> tickerInformation;

        private TradingPairBuilder() {}

        public TradingPairBuilder builder() {
            return new TradingPairBuilder();
        }

        public TradingPairBuilder withPair(String pair) {
            this.pair = pair;
            return this;
        }

        public TradingPairBuilder withTickerInformation(List<TickerInformation> tickerInformation) {
            this.tickerInformation = tickerInformation;
            return this;
        }

        public TradingPair build() {
            return new TradingPair(this);
        }
    }

}