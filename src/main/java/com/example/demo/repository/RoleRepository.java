package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("SELECT ur.role.roleName FROM UserRole ur WHERE ur.user.userId = ?1")
    List<String> getRoleNames(Long userId);
}
