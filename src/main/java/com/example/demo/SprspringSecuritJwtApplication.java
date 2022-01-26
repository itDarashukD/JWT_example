package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repositoty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class SprspringSecuritJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprspringSecuritJwtApplication.class, args);
    }

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = List.of(
                new User(101, "Dzmitry", "password", "e-mail"),
                new User(102, "Vika", "pas", "ve-mail"),
                new User(103, "Vlad", "pass", "vlade-mail")
        );
        repository.saveAll(users);
    }

}
