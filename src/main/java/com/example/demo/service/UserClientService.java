package com.example.demo.service;

import com.example.demo.model.UserClient;
import com.example.demo.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientService {

    @Autowired
    public UserClientRepository userClientRepository;

    public void save(UserClient  userClient) {
        userClientRepository.save(userClient);
    }


}
