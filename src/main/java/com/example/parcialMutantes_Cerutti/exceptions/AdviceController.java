package com.example.parcialMutantes_Cerutti.exceptions;

import com.example.parcialMutantes_Cerutti.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {
    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        String errorMsg = e.getClass() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getMessage())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDto> handleCustomException(CustomException e) {
        String errorMsg = e.getClass() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.badRequest()
                .body(ErrorDto.builder()
                        .errorMsg(e.getMessage())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }
}
