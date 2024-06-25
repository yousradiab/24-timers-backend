package com.example.programmering2024.service;

import com.example.programmering2024.entity.Deltager;
import com.example.programmering2024.entity.Disciplin;
import com.example.programmering2024.entity.Resultat;
import com.example.programmering2024.repository.DeltagerRepository;
import com.example.programmering2024.repository.DisciplinRepository;
import com.example.programmering2024.repository.ResultatRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class DataInitService {

    private final DeltagerRepository deltagerRepository;
    private final DisciplinRepository disciplinRepository;
    private final ResultatRepository resultatRepository;

    public DataInitService(DeltagerRepository deltagerRepository, DisciplinRepository disciplinRepository, ResultatRepository resultatRepository) {
        this.deltagerRepository = deltagerRepository;
        this.disciplinRepository = disciplinRepository;
        this.resultatRepository = resultatRepository;
    }

    @PostConstruct
    public void init() {
        try {
            Random random = new Random();
            List<Deltager> deltagere = new ArrayList<>();
            List<Disciplin> discipliner = createDiscipliner();

            // Definer en fast liste over klubber
            String[] clubs = {"Klub1", "Klub2", "Klub3", "Klub4", "Klub5"};

            for (int i = 0; i < 20; i++) {
                String gender = (i % 2 == 0) ? "M" : "K";
                String club = clubs[random.nextInt(clubs.length)];
                Deltager deltager = new Deltager("Deltager" + i, gender, 10 + random.nextInt(50), club);

                Set<Disciplin> tildelteDiscipliner = new HashSet<>();
                int numberOfDisciplines = 1 + random.nextInt(discipliner.size());
                for (int j = 0; j < numberOfDisciplines; j++) {
                    Disciplin disciplin;
                    do {
                        disciplin = discipliner.get(random.nextInt(discipliner.size()));
                    } while (tildelteDiscipliner.contains(disciplin));
                    tildelteDiscipliner.add(disciplin);
                    deltager.addDisciplin(disciplin);
                }

                deltager = deltagerRepository.save(deltager);

                List<Resultat> resultater = new ArrayList<>();
                for (Disciplin disciplin : deltager.getDiscipliner()) {
                    for (int k = 0; k < 2; k++) {
                        String resultatVaerdi = String.valueOf(random.nextInt(50)); // Uformateret resultatværdi
                        Resultat resultat = new Resultat(disciplin.getResultatType(), new Date(), resultatVaerdi, null, deltager, disciplin);
                        resultat = resultatRepository.save(resultat);
                        resultater.add(resultat);
                    }
                }
                deltager.setResultater(resultater);
                deltagere.add(deltager);
            }

            deltagerRepository.saveAll(deltagere);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize data", e);
        }
    }

    private List<Disciplin> createDiscipliner() {
        List<Disciplin> discipliner = new ArrayList<>();
        String[] disciplineNames = {"100m løb", "Diskoskast", "Trespring", "Højdespring", "Spydkast"};
        String[] resultatTypes = {"Tid", "Afstand", "Point"};

        for (int i = 0; i < disciplineNames.length; i++) {
            Disciplin disciplin = new Disciplin(disciplineNames[i], resultatTypes[i % resultatTypes.length]);
            disciplin = disciplinRepository.save(disciplin);
            discipliner.add(disciplin);
        }
        return discipliner;
    }
}
