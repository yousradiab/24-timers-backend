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

public class DeltagerMapper {
    public static DeltagerDto mapToDto(Deltager deltager) {
        if (deltager == null) {
            return null;
        }

        List<DisciplinDto> discipliner = DisciplinMapper.mapToDtoList(deltager.getDiscipliner());
        List<ResultatDto> resultater = ResultatMapper.mapToDtoList(deltager.getResultater());

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

    public static Deltager mapToEntity(DeltagerDto dto) {
        if (dto == null) {
            return null;
        }

        List<Disciplin> discipliner = DisciplinMapper.mapToEntityList(dto.getDiscipliner());
        List<Resultat> resultater = ResultatMapper.mapToEntityList(dto.getResultater());

        Deltager deltager = new Deltager(
                dto.getName(),
                dto.getKon(),
                dto.getAlder(),
                dto.getKlub()
        );
        deltager.setId(dto.getId());
        deltager.setDiscipliner(discipliner);
        deltager.setResultater(resultater);

        return deltager;
    }
}
