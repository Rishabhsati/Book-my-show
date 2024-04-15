package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.Models.Show;
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
    public ResponseEntity<List<Show>> getShowByMovie(@RequestParam String movieName){
        List<Show> list = showService.getShowByMovie(movieName);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
