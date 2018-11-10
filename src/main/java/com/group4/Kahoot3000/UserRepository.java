package com.group4.Kahoot3000;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUsername(String username);

    @Query(value = "SELECT username FROM users", nativeQuery = true)
    //@Query("SELECT username FROM users")
    List<String> getAllUserNames();
}
