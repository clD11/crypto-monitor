package com.github.crypto_monitor.broadcaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.github.crypto_monitor.broadcaster", exclude = { DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class CryptoMonitorBroadcasterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CryptoMonitorBroadcasterApplication.class);
    }

}