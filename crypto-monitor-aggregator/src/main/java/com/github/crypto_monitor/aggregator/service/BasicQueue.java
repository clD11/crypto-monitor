package com.github.crypto_monitor.aggregator.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component
public class BasicQueue {

    private static final BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<String>(1000);

    public void add(String message) {
        blockingDeque.add(message);
    }

    public String take()  {
        try {
            return blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
