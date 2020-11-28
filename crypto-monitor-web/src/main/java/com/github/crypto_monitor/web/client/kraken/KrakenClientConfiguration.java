package com.github.crypto_monitor.web.client.kraken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KrakenClientConfiguration {

    private final String rootUrl;

    @Autowired
    public KrakenClientConfiguration(@Value("${kraken.root-url}") String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getRootUrl() {
        return rootUrl;
    }
}
