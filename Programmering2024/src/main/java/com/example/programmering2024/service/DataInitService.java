package com.example.programmering2024.service;

import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.entity.Room;
import com.example.programmering2024.repository.HotelRepository;
import com.example.programmering2024.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataInitService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public DataInitService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    public void init() {
        //tilføj data
        Random random = new Random();
        List<Hotel> hotels = new ArrayList<Hotel>();
        for (int i = 0; i < 250; i++) {
            Hotel hotel = new Hotel("Hotel" + i, "city" + i, "street" + i, 1000 + i, "country" + i);
            hotels.add(hotel);
            hotelRepository.save(hotel);
            List<Room> rooms = new ArrayList<Room>();
            for (int j = 0; j < 10; j++) {
                Room room = new Room(1 + j, random.nextInt(3) + 1, random.nextInt(1000) + 500);
                rooms.add(room);
            }



        }
    }
    }

