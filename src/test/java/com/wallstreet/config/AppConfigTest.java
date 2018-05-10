package com.wallstreet.config;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-test.properties")
@ComponentScan(basePackages = {"com.wallstreet.controller", "com.wallstreet.service"})
public class AppConfigTest {
}
