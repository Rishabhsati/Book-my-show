package com.rishabh.bookmyshowapplication.Repository;

import com.rishabh.bookmyshowapplication.Models.Movie;
import com.rishabh.bookmyshowapplication.Models.Show;
import com.rishabh.bookmyshowapplication.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {

    //    @Query(value = "select * from shows where show_date = :showDate
//                                              show_time = :showTime
//                                              movie = :movie
//                                              theater = :theater" , nativeQuery = true)
//    Show findShow(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);

    public Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);
}
