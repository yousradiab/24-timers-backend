package com.example.programmering2024.service;

import com.example.programmering2024.dto.HotelDto;
import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.mapper.HotelMapper;
import com.example.programmering2024.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelDto addHotel(HotelDto hotelDto) {
        // Konverter DTO til entitet
        Hotel hotel = HotelMapper.mapToEntity(hotelDto);
        // Gem entiteten i databasen
        hotelRepository.save(hotel);
        // Konverter entiteten tilbage til DTO
        return hotelDto;
    }

    public List<HotelDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<HotelDto> hotelDtos = new ArrayList<HotelDto>();

        for (Hotel hotel : hotels) {
            HotelDto hotelDto = HotelMapper.mapToDto(hotel);
            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }
}


