package com.gateway.manager.config;

import com.gateway.manager.service.JwtUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;

@Component
public class AuthenticationFilter implements GlobalFilter {

    private final JwtUtils jwtUtil;
    private final RouterValidator validator;

    @Autowired
    public AuthenticationFilter(JwtUtils jwtUtil, RouterValidator validator) {
        this.jwtUtil = jwtUtil;
        this.validator = validator;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (validator.isSecured.test(exchange.getRequest())) {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return Mono.error(new RuntimeException("Missing authorization header"));
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
            } else {
                return Mono.error(new RuntimeException("Invalid authorization header format"));
            }
            try {
                jwtUtil.validateToken(authHeader);
            } catch (Exception e) {
                return Mono.error(new RuntimeException("Unauthorized access"));
            }
        }
        return chain.filter(exchange);
    }
}
