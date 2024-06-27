package com.example.programmering2024.mapper;

import com.example.programmering2024.dto.ResultatDto;
import com.example.programmering2024.entity.Resultat;

import java.util.List;
import java.util.stream.Collectors;

public class ResultatMapper {
    public static ResultatDto mapToDto(Resultat resultat) {
        if (resultat == null) {
            return null;
        }

        return new ResultatDto(
                resultat.getId(),
                resultat.getResultatType(),
                resultat.getDato(),
                resultat.getResultatVaerdi(),
                resultat.getFormattedResult(),
                null,// Map Deltager
                DisciplinMapper.mapToDto(resultat.getDisciplin())
        );
    }

    public static Resultat mapToEntity(ResultatDto dto) {
        if (dto == null) {
            return null;
        }

        Resultat resultat = new Resultat();
        resultat.setId(dto.getId());
        resultat.setResultatType(dto.getResultatType());
        resultat.setResultatVaerdi(dto.getResultatVaerdi());
        resultat.setFormattedResult(resultat.getFormattedResult());
        resultat.setDato(dto.getDato());
        resultat.setDisciplin(DisciplinMapper.mapToEntity(dto.getDisciplin()));
        resultat.setDeltager(DeltagerMapper.mapToEntity(dto.getDeltager()));  // Set Deltager

        return resultat;
    }

    public static List<ResultatDto> mapToDtoList(List<Resultat> resultater) {
        return resultater.stream()
                .map(ResultatMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static List<Resultat> mapToEntityList(List<ResultatDto> dtos) {
        return dtos.stream()
                .map(ResultatMapper::mapToEntity)
                .collect(Collectors.toList());
    }
}
