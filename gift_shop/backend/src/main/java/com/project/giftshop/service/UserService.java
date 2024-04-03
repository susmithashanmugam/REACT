package com.project.giftshop.service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.giftshop.model.User;
import com.project.giftshop.repository.UserRepository;

@Service
public class UserService {

    @Autowired
     UserRepository userRepository;

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

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

//    public User updateUser(String email, User user) {
//        Optional<User> userExists = userRepository.findByEmail(email);
//        if (userExists.isPresent()) {
//            User existingUser = userExists.get();
//            existingUser.setId(user.getId());
////            existingUser.setEmail(user.getEmail());
//            existingUser.setName(user.getName());
//            existingUser.setPassword(user.getPassword());
//            return userRepository.save(existingUser);
//        }

//        return new User();
//    }

    public User updateUser(String email, User user) {
        Optional<User> userExists = userRepository.findByEmail(email);
        if (userExists.isPresent()) {
            User existingUser = userExists.get();;
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            // Update other fields as needed
            return userRepository.save(existingUser);
        }
        return new User();
    }
//    public boolean deleteUser(String email) {
//        if (userRepository.existsById(email)) {
//            userRepository.deleteById(email);
//            return true;
//        }
//        return false;
//      }
//}

    public String deleteUser(String email) {
        boolean userExists = userRepository.existsByEmail(email);
        if (userExists) {
            userRepository.deleteByEmail(email);
            return "User deleted successfully!";
        }
        return "Record not found with email id " + email;
    }
//    public User updateUserBy(String email, User user) {
//        Optional<User> userExists = userRepository.findByEmail(email);
//        if (userExists.isPresent()) {
//            User existingUser = userExists.get();
//
//                existingUser.setName(user.getName());
//
//
//                existingUser.setPassword(user.getPassword());
//
//            return userRepository.save(existingUser);
//        }
//        return new User();
//    }

}