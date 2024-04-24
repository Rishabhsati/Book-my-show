package com.rishabh.Bookmyshowbackend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="tickets")
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
    private String theaterName;
    private String theaterAddress;
    private double totalAmountPaid;
    private List<String> SeatList;

    @JoinColumn
    @ManyToOne
    private User user;
}
