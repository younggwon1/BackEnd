package com.mz.demo.domain.model.order

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigInteger

internal class OrderTest : BehaviorSpec({
    isolationMode = IsolationMode.InstancePerLeaf



    Given("주문 에서"){
        val order = Order(1, OrderStatus.PENDING, "소고기", BigInteger.valueOf(1000))
        When("start 를 호출하면"){
            order.start()
            Then("START 로 변경한다"){
                order.status shouldBe OrderStatus.START
            }
        }
    }
})