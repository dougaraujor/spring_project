package com.dougaraujor.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougaraujor.projeto.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
