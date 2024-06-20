package com.example.programmering2024.api;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.service.DeltagerService;
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


}
