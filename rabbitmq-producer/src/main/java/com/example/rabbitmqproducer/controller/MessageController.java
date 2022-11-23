package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.publisher.QueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class MessageController {

    private final QueueSender sender;

    @GetMapping
    public ResponseEntity<Void> triggerTestMessage() {
        sender.send("Test Message by triggering producer");
        return ResponseEntity.ok().build();
    }

}
