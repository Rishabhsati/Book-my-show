package com.rishabh.bookmyshowapplication.Controllers;

import com.rishabh.bookmyshowapplication.Models.Theater;
import com.rishabh.bookmyshowapplication.Requests.AddTheaterRequest;
import com.rishabh.bookmyshowapplication.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String response = theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
