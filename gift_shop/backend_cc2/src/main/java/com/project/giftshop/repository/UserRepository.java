package com.project.giftshop.repository;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


import com.project.giftshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    void deleteByEmail(String email);
    Page<User> findAll(Pageable pageable);

}