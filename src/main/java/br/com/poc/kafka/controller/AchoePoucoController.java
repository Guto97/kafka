package br.com.poc.kafka.controller;

import br.com.poc.kafka.producer.AchoePoucoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AchoePoucoController {

    @Autowired
    private AchoePoucoProducer achoePoucoProducer;

    @GetMapping("/achoepouco")
    public ResponseEntity<String> sendHello() {
        String hello = "Acho é pouco!!";
        achoePoucoProducer.send(hello);
        return ResponseEntity.ok("Send message with success!!");
    }
}
