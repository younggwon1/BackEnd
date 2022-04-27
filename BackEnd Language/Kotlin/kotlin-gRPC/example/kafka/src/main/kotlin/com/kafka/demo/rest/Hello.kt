package com.kafka.demo.rest

import com.kafka.demo.service.kafka.HelloKafkaProducer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Hello(private val helloKafkaProducer: HelloKafkaProducer) {

    @GetMapping("/hello")
    fun hello2(): String = "Hello world"

    @GetMapping("/send")
    fun producer() = helloKafkaProducer.setKafka("hi")
}

