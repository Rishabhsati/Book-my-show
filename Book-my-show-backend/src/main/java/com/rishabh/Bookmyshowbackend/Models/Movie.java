package com.rishabh.Bookmyshowbackend.Models;

import com.rishabh.Bookmyshowbackend.Enums.Genre;
import com.rishabh.Bookmyshowbackend.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    private double duration;

    private double rating;

    private LocalDate releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language language;
}
