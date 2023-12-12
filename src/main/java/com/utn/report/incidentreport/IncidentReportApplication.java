package com.utn.report.incidentreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.utn.report.incidentreport")
public class IncidentReportApplication {
    public static void main(String[] args) {
        SpringApplication.run(IncidentReportApplication.class, args);
    }

}
