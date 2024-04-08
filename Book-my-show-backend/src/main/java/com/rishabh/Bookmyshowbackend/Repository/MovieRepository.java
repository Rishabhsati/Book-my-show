package com.rishabh.Bookmyshowbackend.Repository;

import com.rishabh.Bookmyshowbackend.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findMovieByMovieName(String movieName);
}
