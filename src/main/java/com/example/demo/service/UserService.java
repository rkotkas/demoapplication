package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void save(User user) {
        userRepository.save(user);
    }

}