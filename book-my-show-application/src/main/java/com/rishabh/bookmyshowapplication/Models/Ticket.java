package com.rishabh.bookmyshowapplication.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterNameAndAddress;
    private double totalAmountPaid;

    @JoinColumn
    @ManyToOne
    private User user;
}
