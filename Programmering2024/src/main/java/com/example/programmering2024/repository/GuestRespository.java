package com.example.programmering2024.repository;

import com.example.programmering2024.dto.GuestDto;
import com.example.programmering2024.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRespository extends JpaRepository<Guest, Long> {

}

