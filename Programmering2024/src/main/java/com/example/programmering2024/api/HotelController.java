package com.example.programmering2024.api;

import com.example.programmering2024.dto.HotelDto;
import com.example.programmering2024.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/gethotels")
    public List<HotelDto> getHotels() {
        return hotelService.getAllHotels();
    }
    @PostMapping("/hotel")
    public HotelDto addHotel(@RequestBody HotelDto request) {
        return hotelService.addHotel(request);
    }
}
