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

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String street;
    private int zip;
    private String country;


    @OneToMany (mappedBy ="hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Room> rooms;

    private LocalDateTime created;
    private LocalDateTime updated;
    public Hotel(String name, String city, String street, int zip, String country) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.country = country;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }
}
