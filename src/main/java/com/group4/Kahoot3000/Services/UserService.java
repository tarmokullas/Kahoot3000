package com.group4.Kahoot3000.Services;

import com.group4.Kahoot3000.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //@Override
    public List<User> findAll() {
        return repository.findAll();
    }

    //@Override
    public void addUser(User user) {
        repository.save(user);
    }

    //@Override
    public User findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public boolean doPasswordsMatch(String password1, String password2) {
        return password1.equals(password2);
    }


    public boolean usernameExists(String username) {
        if (repository.getUsername(username) != null){
            return true;
        } else {
            return false;
        }
    }
}
