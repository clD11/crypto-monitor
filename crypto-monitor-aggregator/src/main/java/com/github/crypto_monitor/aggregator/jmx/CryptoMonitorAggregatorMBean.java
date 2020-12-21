package com.github.crypto_monitor.aggregator.jmx;

import com.github.crypto_monitor.aggregator.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class CryptoMonitorAggregatorMBean {

    private final AggregationService aggregationService;

    @Autowired
    public CryptoMonitorAggregatorMBean(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @ManagedOperation
    public void start() {
        aggregationService.start();
    }

    @ManagedOperation
    public void stop() {
        aggregationService.stop();
    }

}
