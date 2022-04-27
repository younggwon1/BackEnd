package com.mz.demo.infrastructure.rest.order.request

import com.mz.demo.domain.model.order.OrderStatus
import java.math.BigInteger
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateOrderRequest(
    @field:Min(value = 1000, message = "최소 가격은 1000원 이상 입니다.")
    var price: BigInteger,
    @field:NotNull
    var status: OrderStatus,
    @field:NotBlank(message = "설명 필수")
    var orderDesc: String
)