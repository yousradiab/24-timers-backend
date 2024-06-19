package com.example.programmering2024.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Double phoneNumber;
    private LocalDateTime created;
    private LocalDateTime updated;

    @JsonManagedReference
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    public Guest(String username, String firstname, String lastname, String email, Double phoneNumber) {

        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    };

}
