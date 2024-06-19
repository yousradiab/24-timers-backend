package com.example.programmering2024.dto;

import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.entity.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class RoomDto {

    private int roomNumber;
    private int numberOfBeds;
    private int price;
    private Hotel hotel;
    private Set<Reservation> reservations;


}
