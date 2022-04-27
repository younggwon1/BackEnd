package com.mz.demo.domain.port

import com.mz.demo.domain.model.order.Order

interface OrderPersistencePort {
    fun findOrder(id:Long): Order
    fun createOrder(order: Order) : Order
    fun deleteOrder(id: Long)
    fun updateOrder(order: Order): Order
}