package com.example.programmering2024.repository;


import com.example.programmering2024.entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeltagerRepository extends JpaRepository<Deltager, Long> {


}
