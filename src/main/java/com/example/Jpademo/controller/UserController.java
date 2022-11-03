package com.example.Jpademo.controller;

import com.example.Jpademo.domain.User;
import com.example.Jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetails12/app")
public class UserController {
    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/userPost")
//    question mark ? is a wild card character
    public ResponseEntity<?> addUser(@RequestBody  User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.FOUND);
    }


    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId){
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }

    @GetMapping("searchUser/{firstName}")
    public ResponseEntity<?> fetchByFirstName(@PathVariable String firstName){
     return new ResponseEntity<>(userService.getUserByFirstName(firstName),HttpStatus.FOUND);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUserById(@RequestBody User user, @PathVariable int userId){
        return new ResponseEntity<>(userService.updateUser(user,userId),HttpStatus.CREATED);
    }

}
