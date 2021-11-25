package com.example.kafkasub.consume;

import com.example.common.domain.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class GreetingConsumer {

    @KafkaListener(topics = "${greeting.topic.name}", containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting, Acknowledgment ack) {
        try {
            System.out.println("Recieved greeting message: " + greeting);
            // 여기에서 Service Layer를 호출 합니다.

//            if (1 < 0) {
//                throw new Exception("예제를 위한 에러 발생");
//            }
            
            // offset commit
            ack.acknowledge();
        } catch (Exception e) {
            // 에러 처리
            // 임의의 슬립 처리
            // ack.nack(1000 * 5);
        }
    }
}
