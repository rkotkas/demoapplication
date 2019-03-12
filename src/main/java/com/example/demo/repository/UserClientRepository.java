package com.example.demo.repository;

import com.example.demo.model.UserClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository  extends CrudRepository<UserClient, Long> {
}
