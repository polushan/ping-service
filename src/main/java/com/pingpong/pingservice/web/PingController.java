package com.pingpong.pingservice.web;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log
@RestController
@RequestMapping("/ping")
public class PingController {
    private PongClient pongClient;

    @Autowired
    public PingController(PongClient pongClient) {
        this.pongClient = pongClient;
    }

    @GetMapping
    public String ping() {
        log.info("ping");
        UUID uuid = UUID.randomUUID();
        String pong = pongClient.pong();
        return uuid.toString() + " ping " + pong;
    }
}
