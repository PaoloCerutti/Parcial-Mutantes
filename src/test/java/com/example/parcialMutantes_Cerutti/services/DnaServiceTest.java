package com.example.parcialMutantes_Cerutti.services;


import com.example.parcialMutantes_Cerutti.dto.DnaRequest;
import com.example.parcialMutantes_Cerutti.dto.DnaResponse;
import com.example.parcialMutantes_Cerutti.dto.StatsResponse;
import com.example.parcialMutantes_Cerutti.repositories.DnaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DnaServiceTest {

    @Mock
    private DnaRepository dnaRepository;

    @InjectMocks
    private DnaService dnaService;
    @Test
    public void testIsMutantHorizontal() {
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(Arrays.asList("TTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"));

        DnaResponse response = dnaService.isMutant(dnaRequest);
        assertEquals(true, response.isMutant());
    }
    @Test
    public void testIsMutantVertical() {
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(Arrays.asList("TTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CGCCTA", "TCACTG"));

        DnaResponse response = dnaService.isMutant(dnaRequest);
        assertEquals(true, response.isMutant());
    }
    @Test
    public void testIsMutantDiagonal() {
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(Arrays.asList("ATGCGA", "CAGTTC", "TTATGT", "AGAAGG", "CGCCTA", "TCACTG"));

        DnaResponse response = dnaService.isMutant(dnaRequest);
        assertEquals(true, response.isMutant());
    }
    @Test
    public void testIsNotMutant() {
        DnaRequest dnaRequest = new DnaRequest();
        dnaRequest.setDna(Arrays.asList("TTGCGA", "CAGTCC", "TTATGT", "AGAAGG", "CGCCTA", "TCACTG"));

        DnaResponse response = dnaService.isMutant(dnaRequest);
        assertEquals(false, response.isMutant());
    }
    @Test
    public void testGetStats() {
        // Prepara el comportamiento esperado de los métodos del mock
        when(dnaRepository.countByMutant(true)).thenReturn(1L);
        when(dnaRepository.countByMutant(false)).thenReturn(1L);

        // Realiza la llamada al método getStats
        StatsResponse response = dnaService.getStats();

        // Agrega logs para ver lo que se está devolviendo
        System.out.println("Count Mutant: " + response.getCountMutantDna());
        System.out.println("Count Human: " + response.getCountHumanDna());
        System.out.println("Ratio: " + response.getRatio());

        // Asegúrate de que los resultados sean los esperados
        assertEquals(1, response.getCountMutantDna());
        assertEquals(1, response.getCountHumanDna());
        assertEquals(1.0, response.getRatio());
    }
}