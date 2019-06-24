package com.pingpong.pingservice.web;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pong-service", fallbackFactory = PongClient.PongClientFallbackFactory.class)
public interface PongClient {

    @GetMapping("/pong")
    String pong();

    @Component
    class PongClientFallbackFactory implements FallbackFactory<PongClient> {
        @Override
        public PongClient create(Throwable cause) {
            return () -> "fallback; reason was: " + cause.getMessage();
        }
    }
}
