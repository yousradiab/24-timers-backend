package com.example.programmering2024.api;

import com.example.programmering2024.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationRepository reservationRepository;
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
}
