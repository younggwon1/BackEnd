package com.mz.demo.application.adapter

import com.mz.demo.application.api.OrderService
import com.mz.demo.domain.model.order.Order
import com.mz.demo.domain.port.OrderPersistencePort
import org.slf4j.LoggerFactory

class OrderRestAdapter(private val orderPersistencePort: OrderPersistencePort): OrderService {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun findOrder(id: Long): Order {
        return orderPersistencePort.findOrder(id)
    }

    override fun createOrder(order: Order) {
        order.start()

        //필요한 로직 작성
        orderPersistencePort.createOrder(order)
    }

    override fun deleteOrder(id: Long) {
        log.info("delete $id")
        orderPersistencePort.deleteOrder(id)
    }

    override fun updateOrder(order: Order): Order {
        return orderPersistencePort.updateOrder(order)
    }

}