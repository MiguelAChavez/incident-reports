package com.utn.report.incidentreport.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TechnicalDTO {

    private Long id;

    @NotBlank(message = "Matriculation is required")
    @Pattern(regexp = "^\\d{4}-[a-zA-Z]{2}$", message = "Matriculation must be in format 0000-AA")
    private String matriculation;
}
