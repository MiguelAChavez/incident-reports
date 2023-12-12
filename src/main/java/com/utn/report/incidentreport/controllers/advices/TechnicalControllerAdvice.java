package com.utn.report.incidentreport.controllers.advices;

import com.utn.report.incidentreport.dto.ErrorDTO;
import com.utn.report.incidentreport.exceptions.TechnicalValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TechnicalControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDTO> runtimeExceptionHandler(@org.jetbrains.annotations.NotNull RuntimeException exception) {
        ErrorDTO error = ErrorDTO.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TechnicalValidationException.class)
    public ResponseEntity<ErrorDTO> technicalValidationExceptionHandler(@org.jetbrains.annotations.NotNull TechnicalValidationException exception) {
        ErrorDTO error = ErrorDTO.builder()
                .code(exception.getHttpCodes())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
