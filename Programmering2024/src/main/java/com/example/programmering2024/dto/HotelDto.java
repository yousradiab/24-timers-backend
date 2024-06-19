package com.example.programmering2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HotelDto {

    private Long Id;
    private String name;
    private String address;
    private int rooms;
}
