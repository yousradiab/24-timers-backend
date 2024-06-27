package com.example.programmering2024.mapper;

import com.example.programmering2024.dto.DeltagerDto;
import com.example.programmering2024.dto.DisciplinDto;
import com.example.programmering2024.dto.ResultatDto;
import com.example.programmering2024.entity.Deltager;
import com.example.programmering2024.entity.Disciplin;
import com.example.programmering2024.entity.Resultat;
import com.example.programmering2024.mapper.DisciplinMapper;
import com.example.programmering2024.mapper.ResultatMapper;

import java.util.List;
import java.util.stream.Collectors;

// Mapper klasse til at konvertere mellem Deltager entity og DeltagerDto
public class DeltagerMapper {

    // Konverterer en Deltager entity til en DeltagerDto
    public static DeltagerDto mapToDto(Deltager deltager) {
        if (deltager == null) {
            return null; // Returnerer null, hvis deltager er null
        }

        // Mapper discipliner fra entity til DTO
        List<DisciplinDto> discipliner = DisciplinMapper.mapToDtoList(deltager.getDiscipliner());
        // Mapper resultater fra entity til DTO
        List<ResultatDto> resultater = ResultatMapper.mapToDtoList(deltager.getResultater());

        // Opretter og returnerer en ny DeltagerDto baseret på deltager entity
        return new DeltagerDto(
                deltager.getId(),
                deltager.getNavn(),
                deltager.getKon(),
                deltager.getAlder(),
                deltager.getKlub(),
                discipliner,
                resultater
        );
    }

    // Konverterer en DeltagerDto til en Deltager entity
    public static Deltager mapToEntity(DeltagerDto dto) {
        if (dto == null) {
            return null; // Returnerer null, hvis DTO er null
        }

        // Mapper discipliner fra DTO til entity
        List<Disciplin> discipliner = DisciplinMapper.mapToEntityList(dto.getDiscipliner());
        // Mapper resultater fra DTO til entity
        List<Resultat> resultater = ResultatMapper.mapToEntityList(dto.getResultater());

        // Opretter en ny Deltager entity baseret på DTO
        Deltager deltager = new Deltager(
                dto.getName(),
                dto.getKon(),
                dto.getAlder(),
                dto.getKlub()
        );
        // Sætter ID på deltager entity
        deltager.setId(dto.getId());
        // Sætter discipliner på deltager entity
        deltager.setDiscipliner(discipliner);
        // Sætter resultater på deltager entity
        deltager.setResultater(resultater);

        return deltager;
    }
}
