package com.grpc.demo.rest

import com.grpc.demo.service.GrpcClientDemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GrpcClientController(private val grpcClientDemoService: GrpcClientDemoService) {


    @GetMapping("/hello/{name}")
    fun hello(@PathVariable name : String):String{
        return grpcClientDemoService.hello(name)
    }
}