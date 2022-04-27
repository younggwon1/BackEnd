package com.grpc.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class GrpcClientDemoApplication

fun main(args: Array<String>) {
	runApplication<GrpcClientDemoApplication>(*args)
}
