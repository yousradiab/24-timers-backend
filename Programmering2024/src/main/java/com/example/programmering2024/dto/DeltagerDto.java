package com.example.programmering2024.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Data
@Getter
@Setter
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


