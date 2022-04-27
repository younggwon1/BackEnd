package com.mz.demo.infrastructure.mapper

import com.mz.demo.domain.model.order.Order
import com.mz.demo.infrastructure.rest.order.request.CreateOrderRequest
import com.mz.demo.infrastructure.rest.order.request.UpdateOrderRequest
import com.mz.demo.infrastructure.rest.order.response.GetOrderResponse
import com.mz.demo.infrastructure.persistence.jpa.entity.OrderEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface OrderMapper {

    companion object {
        var INSTANCE : OrderMapper = Mappers.getMapper(OrderMapper::class.java)
    }

    fun toOrder(orderEnrity:OrderEntity): Order

    fun toOrder(createOrderRequest: CreateOrderRequest): Order

    fun toOrder(id: Long, updateOrderRequest: UpdateOrderRequest): Order

    fun toOrderEntity(order: Order): OrderEntity

    fun toGetOrder(order: Order): GetOrderResponse


}