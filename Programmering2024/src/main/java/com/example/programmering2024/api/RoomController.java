package com.example.programmering2024.api;

import com.example.programmering2024.service.RoomService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
}
