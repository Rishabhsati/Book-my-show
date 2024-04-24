package com.rishabh.Bookmyshowbackend.Service;

import com.rishabh.Bookmyshowbackend.Models.User;
import com.rishabh.Bookmyshowbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addUser(User user) {
//        userRepository.save(user);
        user = userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Welcome to your Movie Booking Application");
        message.setFrom("jc095623@gmail.com");
        message.setTo(user.getEmailId());
        String body = "Hello " + user.getName() + "!!" + "\n" +
                "Welcome to your Movie Booking Application !! , Feel free " +
                "to browse the movies and use COUPON START100 for instant discount";
        message.setText(body);

        javaMailSender.send(message);

        return "user has been added to the db with the userId "+user.getUserId();
    }

    public String updatePassword(String yourPassword, String newPassword,String mobileNo) throws Exception{
        User user = null;
        user = userRepository.findUserByMobNo(mobileNo);
        if(!user.getPassword().equals(yourPassword)) throw new Exception("password does not matched ");
        user.setPassword(newPassword);
        userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Welcome to your Movie Booking Application");
        message.setFrom("jc095623@gmail.com");
        message.setTo(user.getEmailId());
        String body = "Hello " + user.getName() + "!!" + "\n" +
                "Your password has been changed, if it is not done by you then take security actions";
        message.setText(body);

        javaMailSender.send(message);
        return "password has been changed successfully";
    }
}
