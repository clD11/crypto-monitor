package com.github.crypto_monitor.aggregator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KrakenClientConfig {

    private final String rootUrl;

    @Autowired
    public KrakenClientConfig(@Value("${kraken.root-url}") String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getRootUrl() {
        return rootUrl;
    }
}
