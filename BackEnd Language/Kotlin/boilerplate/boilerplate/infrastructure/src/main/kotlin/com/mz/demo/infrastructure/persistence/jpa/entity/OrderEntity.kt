package com.mz.demo.infrastructure.persistence.jpa.entity

import com.mz.demo.domain.model.order.OrderStatus
import java.math.BigInteger
import javax.persistence.*

@Entity
@Table(name = "tb_order")
class OrderEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    var status: OrderStatus? = null
    var price: BigInteger? = null
    var orderDesc: String? = null
}