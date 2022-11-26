package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.model.Hell;
import com.example.rabbitmqconsumer.model.Paradise;
import com.example.rabbitmqconsumer.repository.HellRepository;
import com.example.rabbitmqconsumer.repository.ParadiseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SupremeCourt {

    private final HellRepository hellRepository;
    private final ParadiseRepository paradiseRepository;

    public void finalDecision(String protocol) {
        String type = protocol.substring(0, 1);
        String fullName = protocol.substring(2);
        if (type.equals("0")) {
            sendToHell(fullName.strip());
        } else {
            sendToParadise(fullName.strip());
        }
    }

    private void sendToHell(String fullName) {
        Hell sinner = new Hell();
        sinner.setName(fullName);
        hellRepository.save(sinner);
        log.info("{} is sent to hell for all his misdemeanors", fullName);
    }

    private void sendToParadise(String fullName) {
        Paradise saint = new Paradise();
        saint.setName(fullName);
        paradiseRepository.save(saint);
        log.info("{} is sent to paradise for all his good deeds", fullName);
    }

}
