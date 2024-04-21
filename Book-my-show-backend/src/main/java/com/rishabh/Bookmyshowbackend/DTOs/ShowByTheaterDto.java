package com.rishabh.Bookmyshowbackend.DTOs;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowByTheaterDto {
    private String movieName;
    private String theaterAdd;
    private LocalDate showDate;
    private LocalTime showTime;
}
