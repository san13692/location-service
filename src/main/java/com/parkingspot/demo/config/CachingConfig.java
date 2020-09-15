package com.parkingspot.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {
    public static final String CACHE = "query";

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(CACHE);

        return cacheManager;
    }

    @CacheEvict(allEntries = true, value = {CACHE})
    @Scheduled(fixedDelay = 600*100, initialDelay = 1000)
    public void reportCacheEvict() {
        System.out.println("Flush Location based Cache ");
    }
}