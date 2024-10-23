package com.example.parcialMutantes_Cerutti.repositories;


import com.example.parcialMutantes_Cerutti.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {
    Dna findByDna(String dna);
    long countByMutant(boolean mutant);
}
