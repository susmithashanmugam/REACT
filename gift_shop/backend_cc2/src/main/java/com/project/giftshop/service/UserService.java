package com.project.giftshop.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import com.project.giftshop.model.User;
import com.project.giftshop.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        Optional<User> userExists=userRepository.findByEmail(user.getEmail());
        if(userExists.isPresent())
            return;
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        boolean userExists=userRepository.existsByEmail(email);
        if(userExists)
            return userRepository.findByEmail(email).get();

        return null;
    }

    public User updateUser(String email,User user)
    {
        Optional<User>userExists=userRepository.findByEmail(email);
        if(userExists.isPresent())
        {
            User existingUser=userExists.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPw(user.getPw());
            existingUser.setPw1(user.getPw1());
            existingUser.setJournal(user.getJournal());
            return userRepository.save(existingUser);


        }
        return new User();
    }
    @Transactional
    public String deleteUser(String email)
    {

        boolean userExists=userRepository.existsByEmail(email);
        if(userExists)
        {
            userRepository.deleteByEmail(email);
            return "User deleted successfully!";

        }
        return "Record not found with email id "+email;
    }

    public User updateUserBy(String email,User user)
    {
        Optional<User> userExists=userRepository.findByEmail(email);
        return userExists.map(existingUser->{
            Optional.ofNullable(user.getUsername()).ifPresent(existingUser::setUsername);
            Optional.ofNullable(user.getPw()).ifPresent(existingUser::setPw);
            Optional.ofNullable(user.getPw1()).ifPresent(existingUser::setPw1);
            Optional.ofNullable(user.getJournal()).ifPresent(existingUser::setJournal);
            return userRepository.save(existingUser);
        }).orElse(null);


    }
    public Optional<User> getUserById(Long id)
    {
        return userRepository.findById(id);


    }
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }





}