package com.rishabh.bookmyshowapplication.Controllers;

import com.rishabh.bookmyshowapplication.Models.TheaterSeat;
import com.rishabh.bookmyshowapplication.Requests.AddTheaterSeatsRequest;
import com.rishabh.bookmyshowapplication.Service.TheaterSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
