package com.grpc.demo.service

import com.grpc.demo.GreetingRequest
import com.grpc.demo.GreetingServiceGrpc
import org.slf4j.LoggerFactory


class GrpcClientDemoService(private val  greetingServiceBlockingStub : GreetingServiceGrpc.GreetingServiceBlockingStub) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun hello(str: String) : String{
        var req = GreetingRequest.newBuilder().setMessage(str).build()

        val result = greetingServiceBlockingStub.greeting(req)

        log.info("result $result.message")

        return result.message
    }
}