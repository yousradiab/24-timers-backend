package com.example.programmering2024.api;


import com.example.programmering2024.service.GuestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

}
