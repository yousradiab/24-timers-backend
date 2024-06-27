package com.example.programmering2024.service;

import com.example.programmering2024.dto.ResultatDto;
import com.example.programmering2024.entity.Deltager;
import com.example.programmering2024.entity.Disciplin;
import com.example.programmering2024.entity.Resultat;
import com.example.programmering2024.mapper.ResultatMapper;
import com.example.programmering2024.repository.DeltagerRepository;
import com.example.programmering2024.repository.DisciplinRepository;
import com.example.programmering2024.repository.ResultatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultatService {

    private final ResultatRepository resultatRepository;
    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;

    public ResultatService(ResultatRepository resultatRepository, DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository) {
        this.resultatRepository = resultatRepository;
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
    }

    public List<ResultatDto> getAllResultater() {
        List<Resultat> resultatList = resultatRepository.findAll();
        return resultatList.stream()
                .map(ResultatMapper::mapToDto)
                .collect(Collectors.toList());
    }


    @Transactional
    public ResultatDto registerSingleResult(ResultatDto resultatDto) {
        Deltager deltager = deltagerRepository.findById(resultatDto.getDeltager().getId())
                .orElseThrow(() -> new RuntimeException("Deltager not found"));
        System.out.println(deltager.toString());

        Disciplin disciplin = disciplinRepository.findById(resultatDto.getDisciplin().getId())
                .orElseThrow(() -> new RuntimeException("Disciplin not found"));
        System.out.println(disciplin.toString());

        // Use the mapper to convert the DTO to an entity
        Resultat resultat = ResultatMapper.mapToEntity(resultatDto);
        System.out.println(resultat.toString());
        resultat.setDeltager(deltager);
        resultat.setDisciplin(disciplin);
        resultat.setFormattedResult(resultat.getFormattedResult()); // Ensure formattedResult is set

        Resultat savedResultat = resultatRepository.save(resultat);
        return ResultatMapper.mapToDto(savedResultat);
    }

}
