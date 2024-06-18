package com.example.programmering2024.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
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
    private int zip;
    private String country;

    @OneToMany (mappedBy ="hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Room> rooms = new HashSet<>();

    public Hotel(Set<Room> rooms, String name, String city, int zip, String country) {
        this.rooms = rooms;
        this.name = name;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }
}
