package com.example.programmering2024.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DeltagerDto {

    private Long id;
    private String name;
    private String kon;
    private int alder;
    private String klub;
    private List<DisciplinDto> discipliner;
    private List<ResultatDto> resultater;

    public DeltagerDto(Long id, String name, String kon, int alder, String klub, List<DisciplinDto> discipliner, List<ResultatDto> resultater) {
        this.id = id;
        this.name = name;
        this.kon = kon;
        this.alder = alder;
        this.klub = klub;
        this.discipliner = discipliner;
        this.resultater = resultater;
    }
}


