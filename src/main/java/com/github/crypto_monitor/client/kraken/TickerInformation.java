package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Arrays;
import java.util.Objects;

@JsonDeserialize(builder = TickerInformation.TickerDtoBuilder.class)
public class TickerInformation {

    @JsonProperty("a")
    private final String[] ask;

    @JsonProperty("b")
    private final String[] bid;

    @JsonProperty("c")
    private final String[] lastTradeClosed;

    @JsonProperty("v")
    private final String[] volume;

    @JsonProperty("p")
    private final String[] volumeWeightedAveragePrice;

    @JsonProperty("t")
    private final String[] numberOfTrades;

    @JsonProperty("l")
    private final String[] low;

    @JsonProperty("h")
    private final String[] high;

    @JsonProperty("o")
    private final String todaysOpenPrice;

    public TickerInformation(TickerDtoBuilder builder) {
        this.ask = builder.ask;
        this.bid = builder.bid;
        this.lastTradeClosed = builder.lastTradeClosed;
        this.volume = builder.volume;
        this.volumeWeightedAveragePrice = builder.volumeWeightedAveragePrice;
        this.numberOfTrades = builder.numberOfTrades;
        this.low = builder.low;
        this.high = builder.high;
        this.todaysOpenPrice = builder.todaysOpenPrice;
    }

    public String[] getAsk() {
        return ask;
    }

    public String[] getBid() {
        return bid;
    }

    public String[] getLastTradeClosed() {
        return lastTradeClosed;
    }

    public String[] getVolume() {
        return volume;
    }

    public String[] getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    public String[] getNumberOfTrades() {
        return numberOfTrades;
    }

    public String[] getLow() {
        return low;
    }

    public String[] getHigh() {
        return high;
    }

    public String getTodaysOpenPrice() {
        return todaysOpenPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TickerInformation that = (TickerInformation) o;
        return Arrays.equals(ask, that.ask) &&
                Arrays.equals(bid, that.bid) &&
                Arrays.equals(lastTradeClosed, that.lastTradeClosed) &&
                Arrays.equals(volume, that.volume) &&
                Arrays.equals(volumeWeightedAveragePrice, that.volumeWeightedAveragePrice) &&
                Arrays.equals(numberOfTrades, that.numberOfTrades) &&
                Arrays.equals(low, that.low) &&
                Arrays.equals(high, that.high) &&
                Objects.equals(todaysOpenPrice, that.todaysOpenPrice);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(todaysOpenPrice);
        result = 31 * result + Arrays.hashCode(ask);
        result = 31 * result + Arrays.hashCode(bid);
        result = 31 * result + Arrays.hashCode(lastTradeClosed);
        result = 31 * result + Arrays.hashCode(volume);
        result = 31 * result + Arrays.hashCode(volumeWeightedAveragePrice);
        result = 31 * result + Arrays.hashCode(numberOfTrades);
        result = 31 * result + Arrays.hashCode(low);
        result = 31 * result + Arrays.hashCode(high);
        return result;
    }

    public static final class TickerDtoBuilder {
        @JsonProperty("a")
        private String[] ask;

        @JsonProperty("b")
        private String[] bid;

        @JsonProperty("c")
        private String[] lastTradeClosed;

        @JsonProperty("v")
        private String[] volume;

        @JsonProperty("p")
        private String[] volumeWeightedAveragePrice;

        @JsonProperty("t")
        private String[] numberOfTrades;

        @JsonProperty("l")
        private String[] low;

        @JsonProperty("h")
        private String[] high;

        @JsonProperty("o")
        private String todaysOpenPrice;

        private TickerDtoBuilder() {}

        public static TickerDtoBuilder builder() {
            return new TickerDtoBuilder();
        }

        public TickerDtoBuilder withAsk(String[] ask) {
            this.ask = ask;
            return this;
        }

        public TickerDtoBuilder withBid(String[] bid) {
            this.bid = bid;
            return this;
        }

        public TickerDtoBuilder withLastTradeClosed(String[] astTradeClosed) {
            this.lastTradeClosed = lastTradeClosed;
            return this;
        }

        public TickerDtoBuilder withVolume(String[] volume) {
            this.volume = volume;
            return this;
        }

        public TickerDtoBuilder withVolumeWeightedAveragePrice(String[] volumeWeightedAveragePrice) {
            this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
            return this;
        }

        public TickerDtoBuilder withNumberOfTrades(String[] numberOfTrades) {
            this.numberOfTrades = numberOfTrades;
            return this;
        }

        public TickerDtoBuilder withLow(String[] low) {
            this.low = low;
            return this;
        }

        public TickerDtoBuilder withHigh(String[] high) {
            this.high = high;
            return this;
        }

        public TickerDtoBuilder withTodaysOpenPrice(String todaysOpenPrice) {
            this.todaysOpenPrice = todaysOpenPrice;
            return this;
        }

        public TickerInformation build() {
            return new TickerInformation(this);
        }
    }

}
