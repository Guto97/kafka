package br.com.poc.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.group-id-1}")
    public void consumer(String message) {
        System.out.println("Consumer 1 - Chorei Manga: " + message);

    }

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.group-id-2}")
    public void consumer1(String message) {
        System.out.println(" - Consumer 2 - Chorei Manga: " + message);

    }
}
