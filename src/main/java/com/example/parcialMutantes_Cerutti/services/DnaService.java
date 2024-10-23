package com.example.parcialMutantes_Cerutti.services;



import com.example.parcialMutantes_Cerutti.dto.DnaRequest;
import com.example.parcialMutantes_Cerutti.dto.DnaResponse;
import com.example.parcialMutantes_Cerutti.dto.StatsResponse;
import com.example.parcialMutantes_Cerutti.entities.Dna;
import com.example.parcialMutantes_Cerutti.exceptions.CustomException;
import com.example.parcialMutantes_Cerutti.repositories.DnaRepository;
import com.example.parcialMutantes_Cerutti.validators.DnaValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DnaService {

    @Autowired
    private DnaRepository dnaRepository;

    private AtomicLong countMutantDna = new AtomicLong(0);
    private AtomicLong countHumanDna = new AtomicLong(0);

    @PostConstruct
    public void init() {
        List<Dna> dnaList = dnaRepository.findAll();
        countMutantDna.set(dnaList.stream().filter(Dna::isMutant).count());
        countHumanDna.set(dnaList.size() - countMutantDna.get());
    }

    public DnaResponse isMutant(DnaRequest dnaRequest) {
        List<String> dnaList = dnaRequest.getDna();
        if (dnaList.size() != 6) {
            throw new CustomException("Invalid DNA sequence length");
        }

        boolean isMutant = DnaValidator.isMutant(dnaList);

        Dna dna = new Dna();
        dna.setDna(String.join(",", dnaList));
        dna.setMutant(isMutant);

        dnaRepository.save(dna);

        if (isMutant) {
            countMutantDna.incrementAndGet();
        } else {
            countHumanDna.incrementAndGet();
        }

        DnaResponse response = new DnaResponse();
        response.setMutant(isMutant);
        return response;
    }

    public StatsResponse getStats() {
        long countMutantDna = dnaRepository.countByMutant(true);
        long countHumanDna = dnaRepository.countByMutant(false);
        double ratio = countHumanDna == 0 ? 0 : (double) countMutantDna / countHumanDna;

        StatsResponse statsResponse = new StatsResponse();
        statsResponse.setCountMutantDna(countMutantDna);
        statsResponse.setCountHumanDna(countHumanDna);
        statsResponse.setRatio(ratio);
        return statsResponse;
    }
}
