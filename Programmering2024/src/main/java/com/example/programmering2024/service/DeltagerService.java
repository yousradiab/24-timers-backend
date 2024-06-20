package com.example.programmering2024.service;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.entity.Deltager;
import com.example.programmering2024.mapper.DeltagerMapper;
import com.example.programmering2024.repository.DeltagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeltagerService {

    private final DeltagerRepository deltagerRepository;

    public DeltagerService(DeltagerRepository deltagerRepository) {
        this.deltagerRepository = deltagerRepository;
    }

    public DeltagerDto addDeltager(DeltagerDto deltagerDto) {
        // Konverter DTO til entitet
        Deltager deltager = DeltagerMapper.mapToEntity(deltagerDto);
        // Gem entiteten i databasen
        deltagerRepository.save(deltager);
        // Konverter entiteten tilbage til DTO
        return deltagerDto;
    }

    public List<DeltagerDto> getAllDeltager() {
        List<Deltager> deltagerList = deltagerRepository.findAll();
        List<DeltagerDto> deltagerDtos = new ArrayList<DeltagerDto>();

        for (Deltager deltager : deltagerList) {
            DeltagerDto deltagerDto = DeltagerMapper.mapToDto(deltager);
            deltagerDtos.add(deltagerDto);
        }
        return deltagerDtos;

        /*
    }
    public HotelDto getHotelById(Long id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        Hotel hotel = hotelOptional.orElseThrow(() -> new RuntimeException("Hotel not found"));
        return HotelMapper.mapToDto(hotel);
    }

 */
}}


