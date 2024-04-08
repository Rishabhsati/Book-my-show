package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.Models.User;
import com.rishabh.Bookmyshowbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        String response = userService.addUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
