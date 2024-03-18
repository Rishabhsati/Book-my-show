package com.rishabh.bookmyshowapplication.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theaters")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String theaterName;

    private String address;

    private Integer noOfScreens;
}
