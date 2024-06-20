package com.example.programmering2024.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DisciplinDto {

    private Long id;
    private String navn;
    private String resultatType;

    public DisciplinDto(Long id, String navn, String resultatType) {
        this.id = id;
        this.navn = navn;
        this.resultatType = resultatType;
    }
}
