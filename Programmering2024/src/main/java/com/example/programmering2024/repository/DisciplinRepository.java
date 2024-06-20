package com.example.programmering2024.repository;

import com.example.programmering2024.entity.Disciplin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinRepository extends JpaRepository<Disciplin, Long> {

    Optional<Disciplin> findByNavn(String navn);}
