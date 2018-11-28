package com.group4.Kahoot3000.Model;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.persistence.*;


@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;

    public User() {

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
        //this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public String getRoles(){
        return "USER";
    }

    public boolean confirmLogin(String inputPassword) {
        return password.equals(Hashing.sha256().hashString(inputPassword + salt, StandardCharsets.UTF_8).toString());
    }

    public String toString() {
        return (getId() + getUsername());
    }
}
