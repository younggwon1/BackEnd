package com.mz.demo.infrastructure.persistence.jpa.repository

import com.mz.demo.infrastructure.persistence.jpa.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long>{
}