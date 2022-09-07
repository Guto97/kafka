package br.com.poc.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "${kafka.name}")
    public void consumer(String message) {
        System.out.println("Consumer Chorei Manga: " + message);

    }

    @KafkaListener(topics = "${topic.name}")
    public void consumer1(String message) {
        System.out.println("Consumer Acho é Pouco: " + message);

    }
}
