package com.rishabh.Bookmyshowbackend.Repository;

import com.rishabh.Bookmyshowbackend.Models.Movie;
import com.rishabh.Bookmyshowbackend.Models.Show;
import com.rishabh.Bookmyshowbackend.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);
}
