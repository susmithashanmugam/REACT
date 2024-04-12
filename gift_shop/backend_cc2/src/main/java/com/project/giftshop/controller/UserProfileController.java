package com.project.giftshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.giftshop.model.User;
import com.project.giftshop.model.UserProfile;
import com.project.giftshop.repository.UserProfileRepo;
import com.project.giftshop.service.UserService;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileRepo upr;

    @Autowired
    private UserService userService;

    @PostMapping("/addProfile")
    public ResponseEntity<?> createUserProfile(@RequestBody UserProfile userProfile) {
        try {
            Long userId = userProfile.getId(); // Assuming userId is included in the request payload
            Optional<User> userOptional = userService.getUserById(userId);

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                userProfile.setUser(user);
                upr.save(userProfile);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving profile");
        }
    }

    @GetMapping("/getProfile")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(upr.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT_FOUND", HttpStatus.EXPECTATION_FAILED);
        }
    }
}