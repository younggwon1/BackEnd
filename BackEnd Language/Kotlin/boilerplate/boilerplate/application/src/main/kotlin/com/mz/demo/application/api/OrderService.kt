package com.mz.demo.application.api

import com.mz.demo.domain.model.order.Order

interface OrderService {
    fun findOrder(id:Long): Order
    fun createOrder(order: Order)
    fun deleteOrder(id:Long)
    fun updateOrder(order: Order): Order
}