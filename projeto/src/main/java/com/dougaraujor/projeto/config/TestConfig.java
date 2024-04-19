package com.dougaraujor.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dougaraujor.projeto.entities.Order;
import com.dougaraujor.projeto.entities.User;
import com.dougaraujor.projeto.entities.enums.OrderStatus;
import com.dougaraujor.projeto.repositories.OrderRepository;
import com.dougaraujor.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        // User
        User u1 = new User(null, "Douglas Araujo", "douglas@gmail.com", "848888888", "123456");
        User u2 = new User(null, "Lucas Araujo", "Lucas@gmail.com", "8488668888", "12345678");
        // User

        // Order
        Order o1 = new Order(null, Instant.parse("2024-04-18T21:23:09Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2024-04-18T21:23:09Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2024-04-18T21:23:09Z"), OrderStatus.CANCELED, u1);
        // Order
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
