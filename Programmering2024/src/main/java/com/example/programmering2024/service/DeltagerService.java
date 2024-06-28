package com.example.programmering2024.service;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.dto.DisciplinDto;
import com.example.programmering2024.entity.Deltager;
import com.example.programmering2024.entity.Disciplin;
import com.example.programmering2024.mapper.DeltagerMapper;
import com.example.programmering2024.repository.DeltagerRepository;
import com.example.programmering2024.repository.DisciplinRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeltagerService {

    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;
    private static final Logger logger = LoggerFactory.getLogger(DeltagerService.class);

    // Constructor for dependency injection of repositories
    public DeltagerService(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }

    // Adds a new Deltager
    public DeltagerDto addDeltager(DeltagerDto deltagerDto) {
        try {
            // Map the DeltagerDto to a Deltager entity
            Deltager deltager = DeltagerMapper.mapToEntity(deltagerDto);

            // Clear results as they should not be added when creating a new participant
            deltager.getResultater().clear();

            // Validate disciplines and map them to entities
            List<Disciplin> validDiscipliner = deltagerDto.getDiscipliner().stream()
                    .map(disciplinDto -> disciplinRepository.findByNavn(disciplinDto.getNavn())
                            .orElseThrow(() -> new RuntimeException("Disciplin not found: " + disciplinDto.getNavn())))
                    .collect(Collectors.toList());

            // Set valid disciplines to the Deltager entity
            deltager.setDiscipliner(validDiscipliner);

            // Save the Deltager entity to the database
            Deltager savedDeltager = deltagerRepository.save(deltager);

            // Map the saved Deltager entity back to a DeltagerDto and return it
            return DeltagerMapper.mapToDto(savedDeltager);
        } catch (Exception e) {
            // Log any errors that occur during the process
            logger.error("Error creating deltager", e);
            throw new RuntimeException("Failed to create deltager", e);
        }
    }

    // Retrieves all Deltager entities and maps them to DeltagerDto objects
    public List<DeltagerDto> getAllDeltager() {
        List<Deltager> deltagerList = deltagerRepository.findAll();
        return deltagerList.stream()
                .map(DeltagerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    // Retrieves a Deltager entity by its ID and maps it to a DeltagerDto
    public DeltagerDto getDeltagerById(Long id) {
        Deltager deltager = deltagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deltager not found"));
        return DeltagerMapper.mapToDto(deltager);
    }

    // Updates an existing Deltager entity with new data from a DeltagerDto
    public DeltagerDto updateDeltager(Long id, DeltagerDto deltagerDto) {
        Deltager deltager = deltagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deltager not found"));

        // Update the Deltager entity with new data
        deltager.setNavn(deltagerDto.getName());
        deltager.setKon(deltagerDto.getKon());
        deltager.setAlder(deltagerDto.getAlder());
        deltager.setKlub(deltagerDto.getKlub());

        // Clear existing disciplines and add the new ones
        deltager.getDiscipliner().clear();
        for (DisciplinDto disciplinDto : deltagerDto.getDiscipliner()) {
            Optional<Disciplin> disciplin = disciplinRepository.findByNavn(disciplinDto.getNavn());
            if (disciplin.isEmpty()) {
                throw new RuntimeException("Disciplin not found: " + disciplinDto.getNavn());
            }
            deltager.addDisciplin(disciplin.get());
        }

        // Save the updated Deltager entity to the database
        Deltager updatedDeltager = deltagerRepository.save(deltager);

        // Map the updated Deltager entity back to a DeltagerDto and return it
        return DeltagerMapper.mapToDto(updatedDeltager);
    }

    // Deletes a Deltager entity by its ID
    public void deleteDeltager(Long id) {
        deltagerRepository.deleteById(id);
    }
}
