package com.dougaraujor.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougaraujor.projeto.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
