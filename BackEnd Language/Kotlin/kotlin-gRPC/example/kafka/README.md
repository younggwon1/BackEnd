# docker run
`docker-compoe up -d`

# producer
`http://localhost:8080/send`

```kotlin
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
```
# consumer
```kotlin
    //HelloKafkaConsumer.kt

    @KafkaListener(topics = ["sink"], groupId = "topic-group")
    fun listen(s:String){
        log.info(s)
    }
```

# kafka message ui
`http://localhost:8085` kafka topic message 확인 