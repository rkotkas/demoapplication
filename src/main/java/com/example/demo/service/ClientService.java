package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Client;
import com.example.demo.model.UserClient;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserClientService userClientService;
    @Autowired
    private AuthenticationService authenticationService;

    public Optional<Client> findClient(Long id) {
        return clientRepository.findById(id);
    }

    public Iterable<Client> getClientListForAuthenticatedUser(Authentication authentication) {
        org.springframework.security.core.userdetails.User authenticatedUser = authenticationService.getUserFromAuthentication(authentication);
        return clientRepository.fetchClients(authenticatedUser.getUsername());
    }

    public void saveClient(Client client, Authentication authentication) {
        org.springframework.security.core.userdetails.User authenticatedUser = authenticationService.getUserFromAuthentication(authentication);
        User user = userService.getUser(authenticatedUser.getUsername());
        clientRepository.save(client);
        userClientService.save(new UserClient(user, client));
    }


    public void updateClient(Client client) {
        clientRepository.save(client);
    }

}