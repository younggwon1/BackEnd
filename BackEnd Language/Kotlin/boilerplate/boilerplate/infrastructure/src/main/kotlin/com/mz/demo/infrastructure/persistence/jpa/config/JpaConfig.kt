package com.mz.demo.infrastructure.persistence.jpa.config

import com.mz.demo.infrastructure.persistence.jpa.adapter.OrderJpaAdapter
import com.mz.demo.infrastructure.persistence.jpa.repository.OrderRepository
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@EnableJpaRepositories(basePackages = ["com.mz.demo.infrastructure.persistence.jpa"])
@EnableTransactionManagement
@Configuration
class JpaConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    fun mysqlDataSource(): DataSource = DataSourceBuilder.create().build()

    @Bean
    fun orderJpaAdapter(orderRepository: OrderRepository): OrderJpaAdapter = OrderJpaAdapter(orderRepository)

}