package com.example.programmering2024.service;


import com.example.programmering2024.repository.ResultatRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultatService {

    private final ResultatRepository resultatRepository;
    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }
}
