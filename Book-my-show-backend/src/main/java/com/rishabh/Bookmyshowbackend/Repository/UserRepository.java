package com.rishabh.Bookmyshowbackend.Repository;

import com.rishabh.Bookmyshowbackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByMobNo(String mobNo);
}
