package com.pingpong.pingservice.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pong-service")
public interface PongClient {

    @GetMapping("/pong")
    String pong();
}
