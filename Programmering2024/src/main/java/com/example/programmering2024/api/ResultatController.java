package com.example.programmering2024.api;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.dto.ResultatDto;
import com.example.programmering2024.service.ResultatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ResultatController {

    private final ResultatService resultatService;

    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @GetMapping("/resultat")
    public List<ResultatDto> getAllResultater() {
        return resultatService.getAllResultater();
    }


    @PostMapping("/resultat")
    public ResponseEntity<ResultatDto> registerSingleResult(@RequestBody ResultatDto resultatDto) {
        try {
            ResultatDto savedResult = resultatService.registerSingleResult(resultatDto);
            return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }}


