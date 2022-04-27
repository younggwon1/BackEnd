package com.grpc.demo.config

import com.grpc.demo.GreetingServiceGrpc
import com.grpc.demo.service.GrpcClientDemoService
import net.devh.boot.grpc.client.inject.GrpcClient
import net.devh.boot.grpc.client.inject.GrpcClientBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@GrpcClientBean(
    clazz = GreetingServiceGrpc.GreetingServiceBlockingStub::class,
    beanName = "greetingServiceBlockingStub",
    client = GrpcClient("local-grpc-server")
)
class GrpcConfig {

    @Bean
    fun grpcClientDemoService(@Autowired greetingServiceBlockingStub: GreetingServiceGrpc.GreetingServiceBlockingStub): GrpcClientDemoService? {
        return GrpcClientDemoService(greetingServiceBlockingStub)
    }
}