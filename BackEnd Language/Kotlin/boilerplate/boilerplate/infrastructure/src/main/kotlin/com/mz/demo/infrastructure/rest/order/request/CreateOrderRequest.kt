package com.mz.demo.infrastructure.rest.order.request

import java.math.BigInteger
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateOrderRequest(
   @field:Min(value = 1000, message = "최소 가격은 1000원 이상 입니다.")
   var price: BigInteger,

   @field:NotBlank(message = "설명 필수")
   var orderDesc: String
)