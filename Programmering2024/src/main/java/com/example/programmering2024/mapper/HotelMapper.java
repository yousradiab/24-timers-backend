package com.example.programmering2024.mapper;

import com.example.programmering2024.dto.HotelDto;
import com.example.programmering2024.dto.RoomDto;
import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.entity.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class HotelMapper {


    public static HotelDto mapToDto(Hotel hotel) {
        Set<RoomDto> rooms = hotel.getRooms().stream().map(RoomMapper :: mapToDto).collect(Collectors.toSet());

       return new HotelDto(hotel.getId(),hotel.getName(), hotel.getCity(), hotel.getStreet(),hotel.getZip(), hotel.getCountry(), rooms);

    }
    public static Hotel mapToEntity(HotelDto hotelDto) {
        return new Hotel(hotelDto.getName(),hotelDto.getCity(), hotelDto.getStreet(), hotelDto.getZip(),hotelDto.getCountry());

    }
}
