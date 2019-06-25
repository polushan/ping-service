package com.pingpong.pingservice.web;


import com.pingpong.pingservice.event.PingPongEventService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log
@RestController
@RequestMapping("/ping")
public class PingController {
    private PongClient pongClient;
    private PingPongEventService eventService;

    @Autowired
    public PingController(PongClient pongClient, PingPongEventService eventService) {
        this.pongClient = pongClient;
        this.eventService = eventService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<PingPong> ping() {
        String uuid = UUID.randomUUID().toString();
        log.info(uuid + " ping");
        String pong = pongClient.pong();
        PingPong pingPong = new PingPong(uuid, "ping", pong);
        eventService.send(pingPong);
        return ResponseEntity.ok(pingPong);
    }
}
