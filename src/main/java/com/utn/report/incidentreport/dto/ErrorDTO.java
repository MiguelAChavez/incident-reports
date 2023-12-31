package com.utn.report.incidentreport.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorDTO {

    private HttpStatus code;
    private String message;

}
