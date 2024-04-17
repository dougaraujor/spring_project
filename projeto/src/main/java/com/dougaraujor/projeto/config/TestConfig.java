package com.dougaraujor.projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dougaraujor.projeto.entities.User;
import com.dougaraujor.projeto.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Douglas Araujo", "douglas@gmail.com", "848888888", "123456");
        User u2 = new User(null, "Lucas Araujo", "Lucas@gmail.com", "8488668888", "12345678");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
