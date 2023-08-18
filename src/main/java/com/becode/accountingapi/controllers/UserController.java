package com.becode.accountingapi.controllers;

import com.becode.accountingapi.models.User;
import com.becode.accountingapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServices userServices;
    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }
    @GetMapping
    @Secured({"ROLE_ADMIN", "ROLE_ACCOUNTANT"})
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServices.getAllUsers();
        return  ResponseEntity.ok(users);
    }
}
