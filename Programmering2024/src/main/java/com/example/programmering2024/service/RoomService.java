package com.example.programmering2024.service;

import com.example.programmering2024.dto.HotelDto;
import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.repository.HotelRepository;
import com.example.programmering2024.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }


}
