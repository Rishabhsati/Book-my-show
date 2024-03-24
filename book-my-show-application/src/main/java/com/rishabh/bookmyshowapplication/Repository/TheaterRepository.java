package com.rishabh.bookmyshowapplication.Repository;

import com.rishabh.bookmyshowapplication.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater,Integer>{
    List<Theater> getTheaterSeatList();
}
