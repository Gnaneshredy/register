package com.example.Register.repository;

import com.example.Register.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    UserLogin findByEmailAndPassword(String email, String password);
}
