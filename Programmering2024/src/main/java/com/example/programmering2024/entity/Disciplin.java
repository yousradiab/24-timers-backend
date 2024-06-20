package com.example.programmering2024.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Disciplin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String navn;
    private String resultatType;

    @OneToMany(mappedBy = "disciplin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultat> resultater = new ArrayList<>();

    @ManyToMany(mappedBy = "discipliner")
    private List<Deltager> deltagere = new ArrayList<>();

    public Disciplin(String navn, String resultatType) {
        this.navn = navn;
        this.resultatType = resultatType;
    }

    public void addResultat(Resultat resultat) {
        this.resultater.add(resultat);
        resultat.setDisciplin(this);
    }

    public void removeResultat(Resultat resultat) {
        this.resultater.remove(resultat);
        resultat.setDisciplin(null);
    }
}
