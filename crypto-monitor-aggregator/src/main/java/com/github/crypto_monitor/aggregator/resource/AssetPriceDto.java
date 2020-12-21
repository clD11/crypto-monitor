package com.github.crypto_monitor.aggregator.resource;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@JsonDeserialize(builder = AssetPriceDto.AssetPriceBuilder.class)
public class AssetPriceDto {

    private final String asset;
    private final String askPrice;
    private final LocalDateTime localDateTime;

    public AssetPriceDto(AssetPriceBuilder builder) {
        this.asset = builder.asset;
        this.askPrice = builder.askPrice;
        this.localDateTime = builder.localDateTime;
    }

    public String getAsset() {
        return asset;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public static final class AssetPriceBuilder {

        private String asset;
        private String askPrice;
        private LocalDateTime localDateTime;

        private AssetPriceBuilder(){}

        public static AssetPriceBuilder builder() {
            return new AssetPriceBuilder();
        }

        public AssetPriceBuilder withAsset(String asset) {
            this.asset = asset;
            return this;
        }

        public AssetPriceBuilder withAskPrice(String askPrice) {
            this.askPrice = askPrice;
            return this;
        }

        public AssetPriceBuilder withLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
            return this;
        }

        public AssetPriceDto build() {
            return new AssetPriceDto(this);
        }
    }

}