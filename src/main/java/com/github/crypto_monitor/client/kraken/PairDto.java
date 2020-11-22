package com.github.crypto_monitor.client.kraken;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = PairDto.PairDtoBuilder.class)
public class PairDto {

    private final String lhs;
    private final String rhs;

    public PairDto(PairDtoBuilder builder) {
        this.lhs = builder.lhs;
        this.rhs = builder.rhs;
    }

    public String getLhs() {
        return lhs;
    }

    public String getRhs() {
        return rhs;
    }

    public static final class PairDtoBuilder {
        private String lhs;
        private String rhs;

        public static PairDtoBuilder builder() {
            return new PairDtoBuilder();
        }

        private PairDtoBuilder() {}

        public PairDtoBuilder withLhs(String lhs) {
            this.lhs = lhs;
            return this;
        }

        public PairDtoBuilder withRhs(String rhs) {
            this.rhs = rhs;
            return this;
        }

        public PairDto build() {
            return new PairDto(this);
        }
    }
}
