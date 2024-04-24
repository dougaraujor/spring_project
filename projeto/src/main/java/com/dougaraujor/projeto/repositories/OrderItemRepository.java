package com.dougaraujor.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougaraujor.projeto.entities.OrderItem;
import com.dougaraujor.projeto.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
