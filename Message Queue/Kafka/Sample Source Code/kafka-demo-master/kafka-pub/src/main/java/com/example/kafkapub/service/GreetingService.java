package com.example.kafkapub.service;


import com.example.common.domain.Courtesy;
import com.example.common.domain.Greeting;

public interface GreetingService {
    public Courtesy greetAndCourtesy(Greeting greeting) throws Exception;
}
