package com.group4.Kahoot3000.Services;

import com.group4.Kahoot3000.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUsername(String username);

    @Query(value = "SELECT username FROM users WHERE username = :username", nativeQuery = true)
    String getUsername(@Param("username") String username);
}
