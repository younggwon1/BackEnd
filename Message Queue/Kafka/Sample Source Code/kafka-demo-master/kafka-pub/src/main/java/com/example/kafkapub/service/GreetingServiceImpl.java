package com.example.kafkapub.service;

import com.example.common.domain.Courtesy;
import com.example.common.domain.Greeting;
import com.example.kafkapub.publish.GreetingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImpl implements GreetingService {
    @Autowired
    GreetingProducer greetingProducer;

    @Override
    public Courtesy greetAndCourtesy(Greeting greeting) throws Exception {
        greetingProducer.sendMessage(greeting);
//        if (1==1) {
//            throw new Exception("사용자 정의 에러를 임의로 발생");
//        }
        // Respose body에 넣을 임의의 데이터 생성
        return new Courtesy("Guest","Hi there? I'm fine and you?");
    }
}
