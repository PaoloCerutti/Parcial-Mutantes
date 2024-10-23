package com.example.parcialMutantes_Cerutti.dto;

import lombok.Data;

@Data
public class StatsResponse {
    private long countMutantDna;
    private long countHumanDna;
    private double ratio;
}
