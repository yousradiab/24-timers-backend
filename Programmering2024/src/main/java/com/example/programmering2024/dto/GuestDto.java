package com.example.programmering2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestDto {

        private Long id;
        private String username;
        private String firstname;
        private String lastname;
        private String email;
        private Double phoneNumber;
        private LocalDateTime created;
        private LocalDateTime updated;
        private Set<Reservation> reservations;

}
