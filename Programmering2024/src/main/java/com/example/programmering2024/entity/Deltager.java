package com.example.programmering2024.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Deltager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String navn;
    private String kon;
    private int alder;
    private String klub;

    @ManyToMany
    @JoinTable(
            name = "deltager_disciplin",
            joinColumns = @JoinColumn(name = "deltager_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplin_id")
    )
    private List<Disciplin> discipliner = new ArrayList<>();

    @OneToMany(mappedBy = "deltager", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Resultat> resultater = new ArrayList<>();

    public Deltager(String navn, String kon, int alder, String klub) {
        this.navn = navn;
        this.kon = kon;
        this.alder = alder;
        this.klub = klub;
    }

    public void addDisciplin(Disciplin disciplin) {
        this.discipliner.add(disciplin);
        disciplin.getDeltagere().add(this);
    }

    public void removeDisciplin(Disciplin disciplin) {
        this.discipliner.remove(disciplin);
        disciplin.getDeltagere().remove(this);
    }

    public void addResultat(Resultat resultat) {
        this.resultater.add(resultat);
        resultat.setDeltager(this);
    }

    public void removeResultat(Resultat resultat) {
        this.resultater.remove(resultat);
        resultat.setDeltager(null);
    }
}
