package com.pingpong.pingservice.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pong-service")
public interface PongClient {

    @GetMapping("/pong")
    @HystrixCommand(fallbackMethod = "failedPong")
    String pong();

    default String failedPong() {
        return "failed";
    }
}
