package com.example.programmering2024.service;

import com.example.programmering2024.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class Reservationservice {

    private final ReservationRepository reservationRepository;
    public Reservationservice(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
}
