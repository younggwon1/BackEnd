package com.mz.demo.infrastructure.rest.order.response

import com.mz.demo.domain.model.order.OrderStatus
import java.math.BigInteger

data class GetOrderResponse(
    var id: Long,
    var status: OrderStatus,
    var price: BigInteger
)