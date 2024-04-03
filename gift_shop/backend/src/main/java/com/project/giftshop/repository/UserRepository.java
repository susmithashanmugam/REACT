package com.project.giftshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.giftshop.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);
}