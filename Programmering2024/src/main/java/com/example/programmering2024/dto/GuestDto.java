package com.example.programmering2024.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestDto {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;

}
