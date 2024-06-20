package com.example.programmering2024.mapper;

import com.example.programmering2024.dto.DisciplinDto;
import com.example.programmering2024.entity.Disciplin;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplinMapper {

    public static DisciplinDto mapToDto(Disciplin disciplin) {
        if (disciplin == null) {
            return null;
        }
        return new DisciplinDto(
                disciplin.getId(),
                disciplin.getNavn(),
                disciplin.getResultatType()
        );
    }

    public static Disciplin mapToEntity(DisciplinDto dto) {
        if (dto == null) {
            return null;
        }
        Disciplin disciplin = new Disciplin();
        disciplin.setId(dto.getId());
        disciplin.setNavn(dto.getNavn());
        disciplin.setResultatType(dto.getResultatType());
        return disciplin;
    }

    public static List<DisciplinDto> mapToDtoList(List<Disciplin> discipliner) {
        return discipliner.stream()
                .map(DisciplinMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static List<Disciplin> mapToEntityList(List<DisciplinDto> disciplinDtos) {
        return disciplinDtos.stream()
                .map(DisciplinMapper::mapToEntity)
                .collect(Collectors.toList());
    }
}
