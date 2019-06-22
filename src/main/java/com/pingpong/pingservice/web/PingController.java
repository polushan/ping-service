package com.pingpong.pingservice.web;


import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping
    public String ping() {
        log.info("ping");
        return "ping";
    }
}
