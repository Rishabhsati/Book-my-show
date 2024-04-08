package com.rishabh.Bookmyshowbackend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalTime showTime; // HH:MM:SS

    private LocalDate showDate; // YYYY:MM:DD

    @ManyToOne
    @JoinColumn
    private com.rishabh.bookmyshowapplication.Models.Movie movie;

    @ManyToOne
    @JoinColumn
    private com.rishabh.bookmyshowapplication.Models.Theater theater;
}
