package com.example.programmering2024.service;

import com.example.programmering2024.dto.GuestDto;
import com.example.programmering2024.entity.Guest;
import com.example.programmering2024.repository.GuestRespository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    private final GuestRespository guestRespository;

    public GuestService(GuestRespository guestRespository) {
        this.guestRespository = guestRespository;
    }
    /*
    public List<GuestDto> getAllGuests() {
        List<GuestDto> guests = GuestRespository.findAll();
        return guests.stream().map(a -> new GuestDto(a, false)).collect(Collectors.toList());


    }

    public GuestDto addGuest(GuestDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new activity");
        }
        Guest newGuest = new Guest();
        updateGuest(newGuest, request);
        guestRespository.save(newGuest);
        return new GuestDto(newGuest, false);
    }


     */

}
