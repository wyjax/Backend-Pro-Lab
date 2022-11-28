package com.wyjax.springgateway.config;

import com.wyjax.springgateway.filter.MainGlobalFilter;
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
