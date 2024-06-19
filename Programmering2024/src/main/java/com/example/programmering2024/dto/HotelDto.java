package com.example.programmering2024.dto;

import com.example.programmering2024.entity.Room;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class HotelDto {

    private Long id;
    private String name;
    private String city;
    private String street;
    private int zip;
    private String country;
    private Set<RoomDto> rooms;

    public HotelDto(Long id, String name, String city, String street, int zip, String country, Set<RoomDto> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.country = country;
        this.rooms = rooms;
    }
}
