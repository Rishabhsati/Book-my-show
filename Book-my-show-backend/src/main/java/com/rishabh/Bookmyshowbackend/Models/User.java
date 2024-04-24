package com.rishabh.Bookmyshowbackend.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    private String password;

    @Column(unique = true)
    private String emailId;

    @Column(unique = true)
    private String mobNo;

}
