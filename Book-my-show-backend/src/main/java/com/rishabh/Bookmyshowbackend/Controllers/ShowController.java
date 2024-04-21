package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.DTOs.ShowByMovieDto;
import com.rishabh.Bookmyshowbackend.DTOs.ShowByTheaterDto;
import com.rishabh.Bookmyshowbackend.Requests.AddShowRequest;
import com.rishabh.Bookmyshowbackend.Requests.AddShowSeatRequest;
import com.rishabh.Bookmyshowbackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody AddShowRequest showRequest){
        String response = showService.addShow(showRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addShowSeats")
    public ResponseEntity<String> addShowSeats(@RequestBody AddShowSeatRequest showSeatRequest){
        String response = showService.addShowSeats(showSeatRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getShowByMovie")
    public ResponseEntity<List<ShowByMovieDto>> getShowByMovie(@RequestParam String movieName){
        try{
            List<ShowByMovieDto> list = showService.getShowByMovie(movieName);
            return new ResponseEntity(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<ShowByTheaterDto>> getShowByTheater(@RequestParam String theaterName){
        try{
            List<ShowByTheaterDto> list = showService.getShowByTheater(theaterName);
            return new ResponseEntity(list,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
