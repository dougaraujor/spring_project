package com.dougaraujor.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougaraujor.projeto.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
