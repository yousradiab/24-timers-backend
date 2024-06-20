package com.example.programmering2024.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ResultatDto {

    private Long id;
    private String resultatType;
    private Date dato;
    private String resultatVaerdi;
    private String formattedResult;
    private DeltagerDto deltager;
    private DisciplinDto disciplin;

    public ResultatDto(Long id, String resultatType, Date dato, String resultatVaerdi, String formattedResult, DeltagerDto deltager, DisciplinDto disciplin) {
        this.id = id;
        this.resultatType = resultatType;
        this.dato = dato;
        this.resultatVaerdi = resultatVaerdi;
        this.formattedResult = formattedResult;
        this.deltager = deltager;
        this.disciplin = disciplin;
    }
}