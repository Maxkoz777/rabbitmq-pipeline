package com.example.rabbitmqconsumer.repository;

import com.example.rabbitmqconsumer.model.Hell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HellRepository extends JpaRepository<Hell, Long> {
}
