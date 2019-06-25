package com.pingpong.pingservice.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class PingPongEventService {
    private Source source;

    @Autowired
    public PingPongEventService(Source source) {
        this.source = source;
    }

    public boolean send(String pingPong) {
        return this.source.output().send(MessageBuilder.withPayload(pingPong).build());
    }
}
