package com.mz.demo.infrastructure.persistence.jpa.adapter

import com.mz.demo.domain.model.order.Order
import com.mz.demo.domain.port.OrderPersistencePort
import com.mz.demo.infrastructure.mapper.OrderMapper
import com.mz.demo.infrastructure.persistence.jpa.repository.OrderRepository
import org.slf4j.LoggerFactory

class OrderJpaAdapter(private val orderRepository: OrderRepository): OrderPersistencePort {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun findOrder(id: Long): Order {
        val orderEntity = orderRepository.findById(id)

        return OrderMapper.INSTANCE.toOrder(orderEntity.get())
    }

    override fun createOrder(order: Order): Order {
        val orderEntity = OrderMapper.INSTANCE.toOrderEntity(order)
        val save = orderRepository.save(orderEntity)

        log.info("order 저장 $save")
        return OrderMapper.INSTANCE.toOrder(save)
    }

    override fun deleteOrder(id: Long) {
        log.info("order 삭제 id: $id")
        orderRepository.deleteById(id)
    }

    override fun updateOrder(order: Order): Order {
        log.info("order updage: $order")

        val orderEntity = OrderMapper.INSTANCE.toOrderEntity(order)

        val save = orderRepository.save(orderEntity)

        return OrderMapper.INSTANCE.toOrder(save)
    }
}