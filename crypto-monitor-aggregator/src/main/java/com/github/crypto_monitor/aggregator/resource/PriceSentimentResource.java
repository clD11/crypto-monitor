package com.github.crypto_monitor.aggregator.resource;

import com.github.crypto_monitor.aggregator.client.kraken.AssetPair;
import com.github.crypto_monitor.aggregator.client.kraken.TickerInformation;
import com.github.crypto_monitor.aggregator.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/price-sentiment")
public class PriceSentimentResource {

    private final AggregationService aggregationService;
    private final PriceSentimentMapper priceSentimentMapper;

    @Autowired
    public PriceSentimentResource(AggregationService aggregationService, PriceSentimentMapper priceSentimentMapper) {
        this.aggregationService = aggregationService;
        this.priceSentimentMapper = priceSentimentMapper;
    }

    @GetMapping(produces = { APPLICATION_JSON_VALUE })
    ResponseEntity<List<AssetPriceDto>> getPriceSentiment(@RequestParam(name = "assetpairs") List<String> query) throws IOException {
        List<AssetPair> assetPairs = priceSentimentMapper.mapToAssertPairs(query);
        Map<String, TickerInformation> assertPairsToTickerInformation = aggregationService.getPriceSentiment(assetPairs);
        List<AssetPriceDto> response = priceSentimentMapper.mapToAssetPrice(assertPairsToTickerInformation);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}