package com.group4.Kahoot3000;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private String salt;

    public  User() {

    }

    //Creates a new user, hashing the password and generating a salt.
    public User(String username, String password) {
        SecureRandom saltGenerator = new SecureRandom();
        byte[] saltBytes = new byte[6];
        saltGenerator.nextBytes(saltBytes);
        String randomSalt = new String(saltBytes, StandardCharsets.UTF_8);
        this.salt = Hashing.sha256().hashString(randomSalt, StandardCharsets.UTF_8).toString();
        this.username = username;
        this.password = Hashing.sha256().hashString(password + salt, StandardCharsets.UTF_8).toString();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public boolean confirmLogin(String inputPassword) {
        return password.equals(Hashing.sha256().hashString(inputPassword + salt, StandardCharsets.UTF_8).toString());
    }

    public String toString() {
        return (getId() + getUsername());
    }
}
