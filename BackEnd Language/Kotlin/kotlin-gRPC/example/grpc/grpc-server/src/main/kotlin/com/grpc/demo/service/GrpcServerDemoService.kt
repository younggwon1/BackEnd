package com.grpc.demo.service

import com.grpc.demo.GreetingRequest
import com.grpc.demo.GreetingResponse
import com.grpc.demo.GreetingServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.slf4j.LoggerFactory

@GrpcService
class GrpcServerDemoService : GreetingServiceGrpc.GreetingServiceImplBase() {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun greeting(request: GreetingRequest, responseObserver: StreamObserver<GreetingResponse>) {
        val message = request.message
        log.info("request data $message")

        val greeting = GreetingResponse.newBuilder().setMessage("hello $message").build()

        responseObserver.onNext(greeting)
        responseObserver.onCompleted()
    }
}