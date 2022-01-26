package com.example.demo.repositoty;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

//    User findByUserName(String username);
    User findByUsername(String username);
}
