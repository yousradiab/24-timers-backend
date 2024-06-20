package com.example.programmering2024.service;

import com.example.programmering2024.entity.Disciplin;
import com.example.programmering2024.repository.DisciplinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinService {

    private final DisciplinRepository disciplinRepository;

    public DisciplinService(DisciplinRepository disciplinRepository) {
        this.disciplinRepository = disciplinRepository;
    }

    public Disciplin createDisciplin(Disciplin disciplin) {
        return disciplinRepository.save(disciplin);
    }

    public List<Disciplin> getAllDiscipliner() {
        return disciplinRepository.findAll();
    }

    public Disciplin getDisciplinById(Long id) {
        return disciplinRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplin not found"));
    }
}
