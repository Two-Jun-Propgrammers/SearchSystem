package com.search_system.controller;

import com.search_system.model.User;
import com.search_system.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping(value = "/login")
    public ResponseEntity<String> login(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password) {
        final boolean auth = authService.login(login, password);

        return auth
                ? new ResponseEntity<>(login, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<String> addUser(
            @RequestBody User user) {
        final boolean created = authService.saveUser(user);
        return created
                ? new ResponseEntity<>(user.getLogin(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
