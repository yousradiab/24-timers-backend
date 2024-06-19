package com.example.programmering2024.api;


import com.example.programmering2024.dto.GuestDto;
import com.example.programmering2024.entity.Guest;
import com.example.programmering2024.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }


    @GetMapping
    public List<Guest> getGuests() {
        List<Guest> lstGuests = guestService.getGuests();
        return lstGuests;
    }

@GetMapping("/{id}")
    public GuestDto getGuestById(@PathVariable long id) {

}

    @PostMapping
    public GuestDto addGuest(@RequestBody GuestDto request) {
        return GuestService.addGuest(request);
    }
}
