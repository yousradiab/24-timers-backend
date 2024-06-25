package com.example.programmering2024.api;

import com.example.programmering2024.dto.ResultatDto;
import com.example.programmering2024.service.ResultatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultat")
public class ResultatController {

    private final ResultatService resultatService;

    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @PostMapping("/single")
    public ResponseEntity<ResultatDto> registerSingleResult(@RequestBody ResultatDto resultatDto) {
        try {
            ResultatDto savedResult = resultatService.registerSingleResult(resultatDto);
            return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> registerMultipleResults(@RequestBody List<ResultatDto> resultater) {
        try {
            resultatService.registerMultipleResults(resultater);
            return ResponseEntity.ok("Results registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    }
