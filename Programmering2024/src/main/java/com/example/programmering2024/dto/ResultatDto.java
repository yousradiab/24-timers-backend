package com.example.programmering2024.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class ResultatDto {

    private Long id;
    private String resultatType;
    private Date dato;
    private String resultatVaerdi;
    private String formattedResult;

    public ResultatDto(Long id, String resultatType, Date dato, String resultatVaerdi, String formattedResult) {
        this.id = id;
        this.resultatType = resultatType;
        this.dato = dato;
        this.resultatVaerdi = resultatVaerdi;
        this.formattedResult = formattedResult;
    }
}
