package com.example.programmering2024.api;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.service.DeltagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")


public class DeltagerController {

    private final DeltagerService deltagerService;

    public DeltagerController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }


    @GetMapping("/deltager")
    public List<DeltagerDto> getAllDeltager() {
        return deltagerService.getAllDeltager();
    }


    @PostMapping("/createdeltager")
    public DeltagerDto addDeltager(@RequestBody DeltagerDto request) {
        return deltagerService.addDeltager(request);
    }


    @GetMapping("/deltager/{id}")
    public ResponseEntity<DeltagerDto> getDeltagerById(@PathVariable Long id) {
        DeltagerDto deltager = deltagerService.getDeltagerById(id);
        return ResponseEntity.ok(deltager);
    }

    @PutMapping("/deltager/{id}")
    public ResponseEntity<DeltagerDto> updateDeltager(@PathVariable Long id, @RequestBody DeltagerDto deltagerDto) {
        DeltagerDto updatedDeltager = deltagerService.updateDeltager(id, deltagerDto);
        return ResponseEntity.ok(updatedDeltager);
    }

    @DeleteMapping("deltager/{id}")
    public ResponseEntity<Void> deleteDeltager(@PathVariable Long id) {
        deltagerService.deleteDeltager(id);
        return ResponseEntity.noContent().build();
    }
}



