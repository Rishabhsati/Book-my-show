package com.rishabh.bookmyshowapplication.Controllers;

import com.rishabh.bookmyshowapplication.Models.Ticket;
import com.rishabh.bookmyshowapplication.Requests.BookTicketRequest;
import com.rishabh.bookmyshowapplication.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("bookTicket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        try{
            Ticket response = ticketService.bookTicket(bookTicketRequest);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            String errMsg = "Error while booking your ticket " + e.getMessage();
            return new ResponseEntity<>(errMsg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
