package com.mmc.security.gate.config;

import com.mmc.security.gate.handler.RequestBodyRoutePredicateFactory;
import com.mmc.security.gate.handler.RequestBodyRoutePredicateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ace
 * @create 2019/1/27.
 */
@Configuration
public class GatewayConfig {
    @Bean
    RequestBodyRoutePredicateFactory requestBodyRoutePredicateFactory() {
        return new RequestBodyRoutePredicateFactory();
    }
}
