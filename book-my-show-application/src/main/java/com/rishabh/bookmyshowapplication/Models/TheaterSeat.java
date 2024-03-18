package com.rishabh.bookmyshowapplication.Models;

import com.rishabh.bookmyshowapplication.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theater_seat")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theater theater;
}
