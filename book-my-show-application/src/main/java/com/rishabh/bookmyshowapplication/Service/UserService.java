package com.rishabh.bookmyshowapplication.Service;

import com.rishabh.bookmyshowapplication.Models.User;
import com.rishabh.bookmyshowapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String addUser(User user) {
//        userRepository.save(user);
        user = userRepository.save(user);
        return "user has been added to the db with the userId "+user.getUserId();
    }
}
