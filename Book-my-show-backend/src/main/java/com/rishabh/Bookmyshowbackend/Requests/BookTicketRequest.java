package com.rishabh.Bookmyshowbackend.Requests;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {
    private String movieName;
    private LocalTime showTime;
    private LocalDate showDate;
    private List<String> RequestedSeats;
    private String mobNo;
    private Integer theaterId;
}
