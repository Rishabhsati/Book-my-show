package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.Models.Movie;
import com.rishabh.Bookmyshowbackend.Requests.UpdateMovieRequest;
import com.rishabh.Bookmyshowbackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateMovie")
    public ResponseEntity<String> updateMovie(@RequestBody UpdateMovieRequest updateMovieRequest){
        String response = movieService.updateMovie(updateMovieRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
