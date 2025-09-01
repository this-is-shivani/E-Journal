package com.ecowishlist.eJournal.controller;

import com.ecowishlist.eJournal.entity.JournalEntry;
import com.ecowishlist.eJournal.entity.User;
import com.ecowishlist.eJournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        service.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<?> updateUserPassword(@RequestBody User user)
    {
        service.updateUserPassword(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
