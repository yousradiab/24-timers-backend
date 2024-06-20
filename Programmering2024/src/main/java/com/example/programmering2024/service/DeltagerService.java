package com.example.programmering2024.service;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.dto.DisciplinDto;
import com.example.programmering2024.entity.Deltager;
import com.example.programmering2024.entity.Disciplin;
import com.example.programmering2024.mapper.DeltagerMapper;
import com.example.programmering2024.mapper.DisciplinMapper;
import com.example.programmering2024.mapper.ResultatMapper;
import com.example.programmering2024.repository.DeltagerRepository;
import com.example.programmering2024.repository.DisciplinRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeltagerService {

    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;
    private static final Logger logger = LoggerFactory.getLogger(DeltagerService.class);

    public DeltagerService(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }
    public DeltagerDto addDeltager(DeltagerDto deltagerDto) {
        try {
            Deltager deltager = DeltagerMapper.mapToEntity(deltagerDto);

            // Clear results as they should not be added when creating a new participant
            deltager.getResultater().clear();

            // Validate disciplines
            List<Disciplin> validDiscipliner = deltagerDto.getDiscipliner().stream()
                    .map(disciplinDto -> disciplinRepository.findByNavn(disciplinDto.getNavn())
                            .orElseThrow(() -> new RuntimeException("Disciplin not found: " + disciplinDto.getNavn())))
                    .collect(Collectors.toList());

            // Set valid disciplines
            deltager.setDiscipliner(validDiscipliner);

            // Save the Deltager
            Deltager savedDeltager = deltagerRepository.save(deltager);
            return DeltagerMapper.mapToDto(savedDeltager);
        } catch (Exception e) {
            logger.error("Error creating deltager", e);
            throw new RuntimeException("Failed to create deltager", e);
        }
    }

    public List<DeltagerDto> getAllDeltager() {
        List<Deltager> deltagerList = deltagerRepository.findAll();
        return deltagerList.stream()
                .map(DeltagerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public DeltagerDto getDeltagerById(Long id) {
        Deltager deltager = deltagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deltager not found"));
        return DeltagerMapper.mapToDto(deltager);
    }

    public DeltagerDto updateDeltager(Long id, DeltagerDto deltagerDto) {
        Deltager deltager = deltagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deltager not found"));

        deltager.setNavn(deltagerDto.getName());
        deltager.setKon(deltagerDto.getKon());
        deltager.setAlder(deltagerDto.getAlder());
        deltager.setKlub(deltagerDto.getKlub());
        deltager.setDiscipliner(deltagerDto.getDiscipliner().stream()
                .map(DisciplinMapper::mapToEntity).collect(Collectors.toList()));
        deltager.setResultater(deltagerDto.getResultater().stream()
                .map(ResultatMapper::mapToEntity).collect(Collectors.toList()));

        Deltager updatedDeltager = deltagerRepository.save(deltager);
        return DeltagerMapper.mapToDto(updatedDeltager);
    }

    public void deleteDeltager(Long id) {
        deltagerRepository.deleteById(id);
    }
}
