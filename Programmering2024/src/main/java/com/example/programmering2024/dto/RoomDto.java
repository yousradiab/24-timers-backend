package com.example.programmering2024.dto;

import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.entity.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class RoomDto {

    private Long id;
    private int roomNumber;
    private int numberOfBeds;
    private int price;
    private Long hotelId;


    public RoomDto(Long id,int roomNumber, int numberOfBeds, int price, Long hotelId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.hotelId = hotelId;
    }
}
