package com.simpleCrudApplication.SimpleCrudApplication.controller;

import com.simpleCrudApplication.SimpleCrudApplication.entity.User;
import com.simpleCrudApplication.SimpleCrudApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/post")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User save = userRepository.save(user);

    return new ResponseEntity<>(save, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> all = userRepository.findAll();

    return new ResponseEntity<>(all,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable("id") long id)
    {
        userRepository.deleteById(id);
        return new ResponseEntity<>("deleted sucessfully!!!",HttpStatus.ACCEPTED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable("id") long id,@RequestBody User user){
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Specified Id not there please try again!!!"));

        User save = userRepository.save(user1);

    return new ResponseEntity<>(save,HttpStatus.OK);
    }

}
