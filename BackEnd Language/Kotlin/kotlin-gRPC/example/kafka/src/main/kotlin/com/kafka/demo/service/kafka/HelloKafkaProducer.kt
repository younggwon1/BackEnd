package com.kafka.demo.service.kafka

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaProducerException
import org.springframework.kafka.core.KafkaSendCallback
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult

class HelloKafkaProducer(private val kafkaTemplate : KafkaTemplate<String, String>) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun setKafka(s: String) {

        val send = kafkaTemplate.send("sink", s)

        send.addCallback(object : KafkaSendCallback<String, String> {
            override fun onSuccess(result: SendResult<String, String>?) {
                log.info("kafka send result: $result")
            }

            override fun onFailure(ex: KafkaProducerException) {
                log.error("kafka send error: $ex")
            }
        })

    }
}