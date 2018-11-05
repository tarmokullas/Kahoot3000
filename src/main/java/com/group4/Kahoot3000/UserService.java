package com.group4.Kahoot3000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<String> getAllUserNames() {
        List<String> allUserNames = new ArrayList<>();

        for (User user : repository.findAll()) {
            allUserNames.add(user.getUsername());
        }
        return allUserNames;
    }
}
