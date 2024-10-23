package com.example.parcialMutantes_Cerutti.controllers;


import com.example.parcialMutantes_Cerutti.dto.DnaRequest;
import com.example.parcialMutantes_Cerutti.dto.DnaResponse;
import com.example.parcialMutantes_Cerutti.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @PostMapping
    public ResponseEntity<DnaResponse> isMutant(@RequestBody DnaRequest dnaRequest) {
        DnaResponse response = dnaService.isMutant(dnaRequest);
        if (response.isMutant()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }
}