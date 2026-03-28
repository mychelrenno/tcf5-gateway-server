package com.devrenno.tcf5.gateway.auth;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface AuthClient {
    @GetExchange("/auth/validate/{token}")
    Mono<Boolean> validateToken(@PathVariable("token") String token);
}
