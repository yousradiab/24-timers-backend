package com.example.programmering2024.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuestDto {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Double phoneNumber;

}
