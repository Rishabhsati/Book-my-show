package com.rishabh.bookmyshowapplication.Models;

import jakarta.persistence.*;
import lombok.*;

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
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
