package com.utn.report.incidentreport.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class TechnicalValidationException extends RuntimeException {

    private HttpStatus httpCodes;

    public TechnicalValidationException(String message) {
        super(message);
    }

    public TechnicalValidationException(HttpStatus httpCodes, String message) {
        super(message);
        this.httpCodes = httpCodes;
    }

}
