package com.ubb.budgetwise_gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("budgets", r -> r.path("/api/budgets/**")
                .filters(f -> f.filter(authenticationFilter))
                .uri("lb://budgets"))
            .route("expenses", r -> r.path("/api/expenses/**")
                .filters(f -> f.filter(authenticationFilter))
                .uri("lb://expenses"))
            .route("users", r -> r.path("/api/users/**")
                .filters(f -> f.filter(authenticationFilter))
                .uri("lb://users"))
            .build();
    }
}
