package com.dougaraujor.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dougaraujor.projeto.entities.Category;
import com.dougaraujor.projeto.entities.Order;
import com.dougaraujor.projeto.entities.Product;
import com.dougaraujor.projeto.entities.User;
import com.dougaraujor.projeto.entities.enums.OrderStatus;
import com.dougaraujor.projeto.repositories.CategoryRepository;
import com.dougaraujor.projeto.repositories.OrderRepository;
import com.dougaraujor.projeto.repositories.ProductRepository;
import com.dougaraujor.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

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

        // Category
        Category cat1 = new Category(null, "Sache");
        Category cat2 = new Category(null, "Ração");
        Category cat3 = new Category(null, "Catolê");
        // Category

        // Product
        Product prod1 = new Product(null, "Sache Afonser", "Sachezinho trains", 9.00, "");
        Product prod2 = new Product(null, "Sache Rata", "Sachezinho trains", 3.00, "");
        Product prod3 = new Product(null, "Catolê Picles", "Catolê especial", 11.00, "");
        Product prod4 = new Product(null, "Chá Catnip", "Cházinho 4:20", 6.00, "");

        // Product
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));

        prod1.getCategories().add(cat3);
        prod2.getCategories().add(cat1);
        prod3.getCategories().add(cat3);
        prod4.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
    }

}
