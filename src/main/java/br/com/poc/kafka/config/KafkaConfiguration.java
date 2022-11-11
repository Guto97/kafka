package br.com.poc.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.topic}")
    private String topic;

    @Value("${spring.kafka.partitions}")
    private String partitions;

    @Value("${spring.kafka.replicas}")
    private String replicas;

    @Value("${spring.kafka.producer.log.retention.minutes}")
    private String retentionInMinutes;

    public KafkaConfiguration(@Value("${spring.kafka.topic}") String topic,
                              @Value("${spring.kafka.partitions}") String partitions,
                              @Value("${spring.kafka.replicas}") String replicas) {
        this.topic = topic;
        this.partitions = partitions;
        this.replicas = replicas;
    }

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(topic)
                .partitions(Integer.parseInt(partitions))
                .replicas(Integer.parseInt(replicas))
                .config(TopicConfig.RETENTION_MS_CONFIG, retentionInMinutes)
                .build();
    }

}
