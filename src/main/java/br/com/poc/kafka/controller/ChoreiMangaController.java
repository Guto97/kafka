package br.com.poc.kafka.controller;

import br.com.poc.kafka.producer.HelloProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloController {

    @Autowired
    private HelloProducer helloProducer;

    @GetMapping("/hello")
    public ResponseEntity<String> sendHello() {
        String hello = "Salve cachorro, deu bom!!";
        helloProducer.send(hello);
        return ResponseEntity.ok("Send message with success!!");
    }
}
