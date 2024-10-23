package com.example.parcialMutantes_Cerutti.validators;

import java.util.List;

public class DnaValidator {

    public static boolean isMutant(List<String> dna) {
        return checkHorizontal(dna) || checkVertical(dna) || checkDiagonal(dna);
    }

    private static boolean checkHorizontal(List<String> dna) {
        for (String row : dna) {
            for (int j = 0; j < row.length() - 3; j++) {
                if (row.charAt(j) == row.charAt(j + 1) &&
                        row.charAt(j) == row.charAt(j + 2) &&
                        row.charAt(j) == row.charAt(j + 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkVertical(List<String> dna) {
        for (int i = 0; i < dna.size() - 3; i++) {
            for (int j = 0; j < dna.get(i).length(); j++) {
                if (dna.get(i).charAt(j) == dna.get(i + 1).charAt(j) &&
                        dna.get(i).charAt(j) == dna.get(i + 2).charAt(j) &&
                        dna.get(i).charAt(j) == dna.get(i + 3).charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonal(List<String> dna) {
        for (int i = 0; i < dna.size() - 3; i++) {
            for (int j = 0; j < dna.get(i).length() - 3; j++) {
                if (dna.get(i).charAt(j) == dna.get(i + 1).charAt(j + 1) &&
                        dna.get(i).charAt(j) == dna.get(i + 2).charAt(j + 2) &&
                        dna.get(i).charAt(j) == dna.get(i + 3).charAt(j + 3)) {
                    return true;
                }
            }
        }
        return false;
    }
}
