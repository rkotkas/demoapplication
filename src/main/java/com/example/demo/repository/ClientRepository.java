package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT uc.client FROM UserClient uc WHERE uc.user.userName = ?1")
    Iterable<Client> fetchClients(String userName);
}
