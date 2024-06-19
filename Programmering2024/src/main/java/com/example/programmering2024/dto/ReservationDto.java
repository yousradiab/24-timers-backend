package com.example.programmering2024.dto;

import com.example.programmering2024.entity.Guest;
import com.example.programmering2024.entity.Room;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ReservationDto {

    private LocalDate reservationDate;
    private int price;
    private Room room;
    private Guest guest;


}
