package com.example.programmering2024.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resultatType;
    private Date dato;
    private String resultatVaerdi;
    private String formattedResult;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "deltager_id", nullable = false)
    private Deltager deltager;

    @ManyToOne
    @JoinColumn(name = "disciplin_id", nullable = false)
    private Disciplin disciplin;

    public Resultat(String resultatType, Date dato, String resultatVaerdi,String formattedResult, Deltager deltager, Disciplin disciplin) {
        this.resultatType = resultatType;
        this.dato = dato;
        this.resultatVaerdi = resultatVaerdi;
        this.formattedResult = formattedResult;
        this.deltager = deltager;
        this.disciplin = disciplin;
    }

    public String getFormattedResult() {
        if ("Tid".equals(resultatType)) {
            return formatTime(resultatVaerdi);
        } else if ("Afstand".equals(resultatType)) {
            return formatDistance(resultatVaerdi);
        }
        return resultatVaerdi;
    }

    private String formatTime(String value) {
        int totalHundredths = Integer.parseInt(value);
        int hours = totalHundredths / 360000;
        int minutes = (totalHundredths / 6000) % 60;
        int seconds = (totalHundredths / 100) % 60;
        int hundredths = totalHundredths % 100;
        return String.format("%02d:%02d:%02d.%02d", hours, minutes, seconds, hundredths);
    }

    private String formatDistance(String value) {
        double meters = Double.parseDouble(value) / 100;
        int wholeMeters = (int) meters;
        int centimeters = (int) ((meters - wholeMeters) * 100);
        return String.format("%d m %02d cm", wholeMeters, centimeters);
    }
}
