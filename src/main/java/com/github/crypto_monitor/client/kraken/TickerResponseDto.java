package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = TickerResponseDto.TickerDtoBuilder.class)
public class TickerResponseDto {

//    a = ask array(<price>, <whole lot volume>, <lot volume>),
//    b = bid array(<price>, <whole lot volume>, <lot volume>),
//    c = last trade closed array(<price>, <lot volume>),
//    v = volume array(<today>, <last 24 hours>),
//    p = volume weighted average price array(<today>, <last 24 hours>),
//    t = number of trades array(<today>, <last 24 hours>),
//    l = low array(<today>, <last 24 hours>),
//    h = high array(<today>, <last 24 hours>),
//    o = today's opening price

    //WIP change monetary to long once have util implemented
    private final String ask;
    private final String bid;
    private final String lastTradeClosed;
    private final String volume;
    private final String volumeWeightedAveragePrice;
    private final String numberOfTrades;
    private final String low;
    private final String high;
    private final String todaysOpenPrice;

    public TickerResponseDto(TickerDtoBuilder builder) {
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

    public String getAsk() {
        return ask;
    }

    public String getBid() {
        return bid;
    }

    public String getLastTradeClosed() {
        return lastTradeClosed;
    }

    public String getVolume() {
        return volume;
    }

    public String getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    public String getNumberOfTrades() {
        return numberOfTrades;
    }

    public String getLow() {
        return low;
    }

    public String getHigh() {
        return high;
    }

    public String getTodaysOpenPrice() {
        return todaysOpenPrice;
    }

    public static final class TickerDtoBuilder {
        private String ask;
        private String bid;
        private String lastTradeClosed;
        private String volume;
        private String volumeWeightedAveragePrice;
        private String numberOfTrades;
        private String low;
        private String high;
        private String todaysOpenPrice;

        private TickerDtoBuilder() {}

        public static TickerDtoBuilder builder() {
            return new TickerDtoBuilder();
        }

        public TickerDtoBuilder withAsk(String ask) {
            this.ask = ask;
            return this;
        }

        public TickerDtoBuilder withBid(String bid) {
            this.bid = bid;
            return this;
        }

        public TickerDtoBuilder withLastTradeClosed(String lastTradeClosed) {
            this.lastTradeClosed = lastTradeClosed;
            return this;
        }

        public TickerDtoBuilder withVolume(String volume) {
            this.volume = volume;
            return this;
        }

        public TickerDtoBuilder withVolumeWeightedAveragePrice(String volumeWeightedAveragePrice) {
            this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
            return this;
        }

        public TickerDtoBuilder withNumberOfTrades(String numberOfTrades) {
            this.numberOfTrades = numberOfTrades;
            return this;
        }

        public TickerDtoBuilder withLow(String low) {
            this.low = low;
            return this;
        }

        public TickerDtoBuilder withHigh(String high) {
            this.high = high;
            return this;
        }

        public TickerDtoBuilder withTodaysOpenPrice(String todaysOpenPrice) {
            this.todaysOpenPrice = todaysOpenPrice;
            return this;
        }

        public TickerResponseDto build() {
            return new TickerResponseDto(this);
        }
    }

}
