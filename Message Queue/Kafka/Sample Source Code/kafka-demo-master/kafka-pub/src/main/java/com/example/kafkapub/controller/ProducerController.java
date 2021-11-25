package com.example.kafkapub.controller;


import com.example.common.domain.Courtesy;
import com.example.common.domain.Greeting;
import com.example.kafkapub.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class ProducerController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = "/publish", method=RequestMethod.POST)
    public Courtesy greetAndCourtesy(@RequestBody final Greeting greeting) throws Exception {
        return greetingService.greetAndCourtesy(greeting);
    }
}
