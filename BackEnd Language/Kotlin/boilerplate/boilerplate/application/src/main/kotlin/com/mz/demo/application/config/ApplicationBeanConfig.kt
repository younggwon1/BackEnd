package com.mz.demo.application.config

import com.mz.demo.application.adapter.OrderRestAdapter
import com.mz.demo.domain.port.OrderPersistencePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationBeanConfig {

    @Bean
    fun orderServiceRestAdapter(orderJpaAdapter: OrderPersistencePort): OrderRestAdapter {
        return OrderRestAdapter(orderJpaAdapter)
    }
}