package com.mz.demo.infrastructure.rest.order

import com.mz.demo.application.api.OrderService
import com.mz.demo.infrastructure.mapper.OrderMapper
import com.mz.demo.infrastructure.rest.order.request.CreateOrderRequest
import com.mz.demo.infrastructure.rest.order.request.UpdateOrderRequest
import com.mz.demo.infrastructure.rest.order.response.GetOrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Validated
class OrderController(private val orderServiceRestAdapter: OrderService) {

    @GetMapping("/orders/{id}")
    fun findOrder(@PathVariable id:Long):ResponseEntity<GetOrderResponse>{
        val order = orderServiceRestAdapter.findOrder(id)

        OrderMapper.INSTANCE.toGetOrder(order)
        return ResponseEntity.ok(OrderMapper.INSTANCE.toGetOrder(order))
    }

    @PostMapping("/orders")
    fun createOrder(@Valid @RequestBody createOrderRequest: CreateOrderRequest):ResponseEntity<Void>{
        orderServiceRestAdapter.createOrder(OrderMapper.INSTANCE.toOrder(createOrderRequest))
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/orders/{id}")
    fun deleteOrder(@PathVariable id:Long):ResponseEntity<Void>{
        orderServiceRestAdapter.deleteOrder(id)

        return ResponseEntity.ok().build()
    }

    @PutMapping("/orders/{id}")
    fun updateOrder(@PathVariable id: Long, @RequestBody updateOrderRequest: UpdateOrderRequest):ResponseEntity<GetOrderResponse>{
        val order = OrderMapper.INSTANCE.toOrder(id, updateOrderRequest)
        val result = orderServiceRestAdapter.updateOrder(order)
        return ResponseEntity.ok(OrderMapper.INSTANCE.toGetOrder(result))
    }
}