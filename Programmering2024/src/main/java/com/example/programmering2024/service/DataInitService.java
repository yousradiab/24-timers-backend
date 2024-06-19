package com.example.programmering2024.service;

import com.example.programmering2024.entity.Hotel;
import com.example.programmering2024.entity.Room;
import com.example.programmering2024.repository.HotelRepository;
import com.example.programmering2024.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataInitService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public DataInitService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }
@PostConstruct
    public void init() {
        //tilføj data
        Random random = new Random();
        List<Hotel> hotels = new ArrayList<Hotel>();
        for (int i = 0; i < 250; i++) {
            Hotel hotel = new Hotel("Hotel" + i, "city" + i, "street" + i, 1000 + i, "country" + i);
            hotelRepository.save(hotel);

            Set<Room> rooms = new HashSet<Room>();
            for (int j = 0; j < 10; j++) {
                Room room = new Room(1 + j, random.nextInt(4) + 1, random.nextInt(1000) + 500);
                room.setHotel(hotel);
                rooms.add(room);
            };
            hotel.setRooms(rooms);
            hotels.add(hotel);


        }
        hotelRepository.saveAll(hotels);
    }
    }

