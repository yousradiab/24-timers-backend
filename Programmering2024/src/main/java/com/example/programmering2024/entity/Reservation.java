package com.example.programmering2024.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate reservationDate;
    private int price;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    private LocalDateTime created;
    private LocalDateTime updated;

    public Reservation(LocalDate reservationDate, int price, Room room, Guest guest) {
        this.reservationDate = reservationDate;
        this.price = price;
        this.room = room;
        this.guest = guest;
        this.created = created;
        this.updated = updated;
    }
}
