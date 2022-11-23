package com.example.rabbitmqproducer.initialization;

import com.example.rabbitmqproducer.publisher.QueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BroadcastHello implements CommandLineRunner {

    private final QueueSender sender;

    @Override
    public void run(String... args) throws Exception {
        sender.send("Hello message!");
    }
}
