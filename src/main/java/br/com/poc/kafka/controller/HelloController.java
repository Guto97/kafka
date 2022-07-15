package br.com.poc.kafka.controller;

import br.com.poc.kafka.producer.HelloProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
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
