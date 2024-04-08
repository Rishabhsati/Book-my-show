package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.Requests.AddShowRequest;
import com.rishabh.Bookmyshowbackend.Requests.AddShowSeatRequest;
import com.rishabh.Bookmyshowbackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
