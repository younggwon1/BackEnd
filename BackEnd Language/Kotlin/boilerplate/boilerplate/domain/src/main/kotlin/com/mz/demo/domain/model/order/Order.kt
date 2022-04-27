package com.mz.demo.domain.model.order

import java.math.BigInteger


data class Order(
    var id: Long,
    var status: OrderStatus?,
    var orderDesc: String,
    var price: BigInteger
){

    fun start() {
        status = OrderStatus.START
    }
}