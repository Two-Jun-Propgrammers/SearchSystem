package com.search_system.service;

import com.search_system.model.User;
import com.search_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean login(String login, String password){
        User user = userRepository.findByLogin(login);
        if(user.equals(null)){
            return false;
        }
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            return true;
        }
        return false;
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
}
