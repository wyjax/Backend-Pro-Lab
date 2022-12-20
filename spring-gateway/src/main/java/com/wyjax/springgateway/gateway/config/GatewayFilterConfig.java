package com.wyjax.springgateway.gateway.config;

import com.wyjax.springgateway.gateway.filter.MainGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayFilterConfig {

    @Bean
    public GlobalFilter globalFilter() {
        return new MainGlobalFilter();
    }
}