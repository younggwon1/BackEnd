package com.mz.demo.application.adapter

import com.mz.demo.domain.model.order.Order
import com.mz.demo.domain.model.order.OrderStatus
import com.mz.demo.domain.port.OrderPersistencePort
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe
import io.mockk.*
import java.math.BigInteger

internal class OrderRestAdapterTest: BehaviorSpec({
    isolationMode = IsolationMode.InstancePerLeaf

    var orderPersistencePort =mockk<OrderPersistencePort>()
    var orderRestAdapter  = OrderRestAdapter(orderPersistencePort)


    Given("주문을 하면"){
        val order = Order(0, OrderStatus.PENDING, "소고기", BigInteger.valueOf(10000))
        val result = Order(1, OrderStatus.START, "소고기", BigInteger.valueOf(10000))
        val slot = slot<Order>()
        every { orderPersistencePort.createOrder(capture(slot)) } returns result

        When("DB에 저장 한다"){
            orderRestAdapter.createOrder(order)

            Then("status 값이 START로 변경 된다."){
                val captured = slot.captured
                println("captured $captured")
                captured.status shouldBe OrderStatus.START
            }
        }
    }

    Given("주문을 삭제하면"){
        every { orderPersistencePort.deleteOrder(any<Long>()) } just Runs

        When("DB에서 삭제 한다."){
            orderRestAdapter.deleteOrder(1)

            Then("delete 메소드를 호출한다"){
                verify { orderPersistencePort.deleteOrder(any<Long>()) }
            }
        }
    }

    Given("주문을 조회하면"){
        val result = Order(1, OrderStatus.START, "소고기", BigInteger.valueOf(10000))
        every { orderPersistencePort.findOrder(any<Long>()) } returns result

        When("DB에서 조회를 한다."){
            val order = orderRestAdapter.findOrder(1)

            Then("주문을 데이터를 가져온다"){
                order.id shouldBe 1
                order.orderDesc shouldBe "소고기"
            }
        }
    }

    Given("주문을 변경하면"){
        val order = Order(1, OrderStatus.PENDING, "소고기", BigInteger.valueOf(10000))
        every { orderPersistencePort.updateOrder(any<Order>()) } returns order

        When("DB에 저장을 한다"){
            orderRestAdapter.updateOrder(order)

            Then("update 메소드를 호출한다"){
                verify { orderPersistencePort.updateOrder(any<Order>()) }
            }
        }

    }

})