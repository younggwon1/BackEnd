package com.kafka.demo.service.kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener


class HelloKafkaConsumer {
    private val log = LoggerFactory.getLogger(javaClass)


    @KafkaListener(topics = ["sink"], groupId = "topic-group")
    fun listen(s:String){
        log.info(s)
    }


}