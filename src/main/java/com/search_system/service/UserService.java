package com.search_system.service;

import com.search_system.model.User;
import com.search_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User search(String name){
        return userRepository.search(name);
    }

    public boolean saveUser(User user){
        return saveUser(user, "USER");
    }

    public boolean saveUser(User user, String role) {
        user.setId(UUID.randomUUID());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoleId(userRepository.getRole(role));
        boolean result = userRepository.saveUser(user);

        return result;
    }

    public boolean update(UUID oldId, User user) {
        return userRepository.update(oldId, user);
    }

    public boolean delete(UUID id) {
        boolean result = userRepository.delete(id);
        return result;
    }
}
