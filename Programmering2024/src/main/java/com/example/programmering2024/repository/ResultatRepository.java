package com.example.programmering2024.repository;

import com.example.programmering2024.entity.Resultat;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultatRepository extends JpaRepository<Resultat, String> {

}

