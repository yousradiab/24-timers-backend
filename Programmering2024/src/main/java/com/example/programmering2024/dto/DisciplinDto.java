package com.example.programmering2024.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
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
