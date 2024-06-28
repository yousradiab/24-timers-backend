package com.example.programmering2024.api;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.service.DeltagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marker klassen som en REST-controller og tillad Cross-Origin anmodninger fra angivet oprindelse
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DeltagerController {

    // Serviceklasse for at håndtere forretningslogik og databasetransaktioner
    private final DeltagerService deltagerService;

    // Constructor for dependency injection af deltagerService
    public DeltagerController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }

    // Hent alle deltagere
    @GetMapping("/deltager")
    public List<DeltagerDto> getAllDeltager() {
        // Kalder service for at hente alle deltagere og returnerer dem som en liste af DeltagerDto
        return deltagerService.getAllDeltager();
    }

    // Opret en ny deltager
    @PostMapping("/createdeltager")
    public DeltagerDto addDeltager(@RequestBody DeltagerDto request) {
        // Kalder service for at tilføje en ny deltager og returnerer den oprettede DeltagerDto
        return deltagerService.addDeltager(request);
    }

    // Hent en deltager baseret på ID
    @GetMapping("/deltager/{id}")
    public ResponseEntity<DeltagerDto> getDeltagerById(@PathVariable Long id) {
        // Kalder service for at hente deltager baseret på ID
        DeltagerDto deltager = deltagerService.getDeltagerById(id);
        // Returnerer en ResponseEntity med status 200 OK og den fundne deltager
        return ResponseEntity.ok(deltager);
    }

    // Opdater en eksisterende deltager
    @PutMapping("/deltager/{id}")
    public ResponseEntity<DeltagerDto> updateDeltager(@PathVariable Long id, @RequestBody DeltagerDto deltagerDto) {
        // Kalder service for at opdatere deltager baseret på ID og nye data
        DeltagerDto updatedDeltager = deltagerService.updateDeltager(id, deltagerDto);
        // Returnerer en ResponseEntity med status 200 OK og den opdaterede deltager
        return ResponseEntity.ok(updatedDeltager);
    }

    // Slet en deltager baseret på ID
    @DeleteMapping("/deltager/{id}")
    public ResponseEntity<Void> deleteDeltager(@PathVariable Long id) {
        // Kalder service for at slette deltager baseret på ID
        deltagerService.deleteDeltager(id);
        // Returnerer en ResponseEntity med status 204 No Content
        return ResponseEntity.noContent().build();
    }
}
