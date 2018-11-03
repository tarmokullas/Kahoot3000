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
        List<User> users = (List<User>) repository.findAll();
        return users;
    }

    //@Override
    public void addUser(User user){
        repository.save(user);
    }

    //@Override
    public User findUserByUsername(String username){
        User user = repository.findByUsername(username);
        return user;
    }

    public boolean doPasswordsMatch (String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public List<String> getAllUserNames(){
        List<String> allUserNames = new ArrayList<String>();

        for (User user : repository.findAll()) {
            allUserNames.add(user.getUsername());
        }
        return allUserNames;
    }
}
