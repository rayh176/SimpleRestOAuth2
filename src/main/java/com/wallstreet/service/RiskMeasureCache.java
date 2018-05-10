package com.wallstreet.service;

import com.wallstreet.config.AppConfig;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Main entry point to EHCache to store and retrieve data
 */
@Service
public class RiskMeasureCache {

    private Cache<String, String> cache;
    private static volatile EhCacheManager ehCacheManager;


    public RiskMeasureCache() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        if (ehCacheManager == null)
            ehCacheManager  = context.getBean(EhCacheManager.class);
        cache = ehCacheManager.getCache("ACCESS_TOKEN");
    }

    /**
     * Add data to the cache
     * @param key
     * @param value
     */
    public void addTokenToCache(String key, String value) {
        cache.put(key, value);
    }

    /**
     * Get Data from Cache
     * @param key
     * @return
     */
    public String getTokenFromCache(String key) {
        return cache.get(key);
    }

}
