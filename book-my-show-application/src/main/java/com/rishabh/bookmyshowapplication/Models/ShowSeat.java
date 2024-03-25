package com.rishabh.bookmyshowapplication.Models;

import com.rishabh.bookmyshowapplication.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "show_seats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private com.rishabh.bookmyshowapplication.Models.Show show;
}
