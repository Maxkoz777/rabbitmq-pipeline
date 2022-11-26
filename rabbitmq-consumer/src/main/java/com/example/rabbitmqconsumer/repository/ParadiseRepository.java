package com.example.rabbitmqconsumer.repository;

import com.example.rabbitmqconsumer.model.Paradise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParadiseRepository extends JpaRepository<Paradise, Long> {
}
