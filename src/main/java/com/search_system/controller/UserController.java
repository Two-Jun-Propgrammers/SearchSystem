package com.search_system.controller;

import com.search_system.model.User;
import com.search_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

//    @GetMapping(value = "/findById")
//    public ResponseEntity<List<User>> search(
//            @RequestParam(value = "name") String name) {
//        final List<User> users = userService.search(name);
//
//        return users != null && !users.isEmpty()
//                ? new ResponseEntity<>(users, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @GetMapping(value = "/findAll")
//    public ResponseEntity<List<User>> search() {
//        final List<User> users = userService.findAll();
//
//        return users != null && !users.isEmpty()
//                ? new ResponseEntity<>(users, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @PostMapping(value = "/registration")
//    public ResponseEntity<?> addUser(
//            @RequestBody User user) {
//        final boolean created = userService.saveUser(user);
//        return created
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

//    @PutMapping(value = "/modifyUser")
//    public ResponseEntity<?> modifyUser(
//            @RequestParam(value = "oldId") UUID oldId,
//            @RequestBody User newUser) {
//        final boolean updated = userService.update(oldId, newUser);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

//    @DeleteMapping(value = "/removeUser")
//    public ResponseEntity<?> removeUser(
//            @RequestParam(value = "id") UUID id) {
//        final boolean deleted = userService.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
}
