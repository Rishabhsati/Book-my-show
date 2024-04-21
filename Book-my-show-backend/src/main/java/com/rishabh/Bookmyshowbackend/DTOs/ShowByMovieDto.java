package com.rishabh.Bookmyshowbackend.DTOs;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowByMovieDto {
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterName;
    private String theaterAdd;
}
