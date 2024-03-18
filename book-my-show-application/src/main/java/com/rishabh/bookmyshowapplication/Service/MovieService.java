package com.rishabh.bookmyshowapplication.Service;

import com.rishabh.bookmyshowapplication.Models.Movie;
import com.rishabh.bookmyshowapplication.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        movie = movieRepository.save(movie);
        return "The movie has been saved to the DB with movieId "+movie.getMovieId();
    }


}
