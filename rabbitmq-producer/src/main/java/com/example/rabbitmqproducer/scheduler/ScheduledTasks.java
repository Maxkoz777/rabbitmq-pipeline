package com.example.rabbitmqproducer.scheduler;

import com.example.rabbitmqproducer.publisher.QueueSender;
import com.github.javafaker.Faker;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private final QueueSender sender;

    @Scheduled(fixedRate = 2, timeUnit = TimeUnit.SECONDS)
    public void sendScheduledMessage() {
        int messageType = new Random().nextInt() % 2;
        Faker faker = new Faker();
        String fullName = faker.name().firstName() + " " + faker.name().lastName();
        sender.send("Scheduled message of type - " + messageType + " " + fullName);
        log.info("Message of type {} is sent to queue", messageType);
    }

}
