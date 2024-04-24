package com.rishabh.Bookmyshowbackend.Controllers;

import com.rishabh.Bookmyshowbackend.Models.Ticket;
import com.rishabh.Bookmyshowbackend.Requests.BookTicketRequest;
import com.rishabh.Bookmyshowbackend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PutMapping("cancleTicket")
    public ResponseEntity cancleTicket(@RequestParam UUID ticketId) throws Exception {
        try{
            ticketService.cancelTicket(ticketId);
            String response = "Your ticket has been cancled successfully with the ticket id : " + ticketId;
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            String errMsg = "Error while cancling your ticket " + e.getMessage();
            return new ResponseEntity<>(errMsg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
