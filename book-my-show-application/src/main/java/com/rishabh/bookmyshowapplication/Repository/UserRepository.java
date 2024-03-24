package com.rishabh.bookmyshowapplication.Repository;

import com.rishabh.bookmyshowapplication.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByMobNo(String mobNo);
}
