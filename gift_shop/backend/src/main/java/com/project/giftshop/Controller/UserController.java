package com.project.giftshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.giftshop.model.User;
import com.project.giftshop.service.UserService;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?>saveUser(@RequestBody User user)
    {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>("User registered successfully",HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong",HttpStatus.EXPECTATION_FAILED);
        }
    }


    @GetMapping("/get")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email)
    {
        try {
            return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong",HttpStatus.OK);

        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUser() {
        try {
            return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
        }
    }
//    @PutMapping("/update/{email}")
//    public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody User user) {
//        try {
//            return new ResponseEntity<>(userService.updateUser(email, user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

    @PutMapping("/users/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User updateUser) {
        User updatedUser = userService.updateUser(email, updateUser);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }
//
//    @DeleteMapping("/delete/{email}")
//    public ResponseEntity<?> deleteUser(@PathVariable String email) {
//        try {
//            return new ResponseEntity<>(userService.deleteUser(email), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//    }

//   @DeleteMapping("/users/{id}")
//   public ResponseEntity<Void> deleteUser(@PathVariable String id)
//   {
//       boolean deleted = userService.deleteUser(id);
//       return  deleted ? ResponseEntity.noContent().build();
//       ResponseEntity.notFound().build();
//   }


@DeleteMapping("/delete/{email}")
public ResponseEntity<Void> deleteUser(@PathVariable String email) {
    boolean deleted = Boolean.parseBoolean(userService.deleteUser(email));
    if (deleted) {
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}


//    @PatchMapping("/patch/{email}")
//    public ResponseEntity<?> updateUserBy(@PathVariable String email, @RequestBody User user) {
//        try {
//            return new ResponseEntity<>(userService.updateUserBy(email, user), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Something went wrong", HttpStatus.EXPECTATION_FAILED);
//        }
//
//    }
}