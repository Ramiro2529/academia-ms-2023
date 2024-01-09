package com.ibm.academia.user.controller;

import com.ibm.academia.user.exception.BadRequestExceptionBody;
import com.ibm.academia.user.model.User;
import com.ibm.academia.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/v1/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

       Optional<User> userFound= service.findUserById(id);
       return new ResponseEntity<>(userFound, HttpStatus.OK);
    }

    @GetMapping("/v1/findAll")
    public ResponseEntity<?> findAll (){
        List<User> usersFound=service.findAllUsers();

        return new ResponseEntity<>(usersFound, HttpStatus.OK);
    }

    @PostMapping("/v1/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user, BindingResult result){

        if (result.hasErrors())
            throw new BadRequestExceptionBody("Hay errores en tu petición", result.getFieldErrors());
       User userCreated= service.createUser(user);

       return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @DeleteMapping("/v1/deleteUserById/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        service.deleteUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body("User with id "+id+" deleted");
    }

    @PostMapping("/v1/updateUser/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id){

        service.updateUser(user, id);
        return new ResponseEntity<>("user with id "+id+" updated",HttpStatus.OK);
    }


}
