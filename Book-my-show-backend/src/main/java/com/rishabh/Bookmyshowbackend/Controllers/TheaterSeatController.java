package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.Requests.AddTheaterSeatsRequest;
import com.rishabh.Bookmyshowbackend.Service.TheaterSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theaterSeat")
public class TheaterSeatController {

    @Autowired
    private TheaterSeatService theaterSeatService;

    @PostMapping("/addTheaterSeats")
    public ResponseEntity<String> addTheaterSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest){
        String response = theaterSeatService.addTheaterSeats(addTheaterSeatsRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
