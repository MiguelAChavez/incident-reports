package com.utn.report.incidentreport.controllers;

import com.utn.report.incidentreport.entity.Technical;
import com.utn.report.incidentreport.services.implementations.TechnicalServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/technical")
public class TechnicalController {
    private final TechnicalServiceImp technicalService;

    public TechnicalController(TechnicalServiceImp technicalController) {
        this.technicalService = technicalController;
    }

    @GetMapping("/all")
    public List<Technical> getAll() {
        return technicalService.findAll();
    }

    @GetMapping("/{id}")
    public Technical getById(@PathVariable Long id) {
        return technicalService.findById(id).orElseThrow(() -> new EntityNotFoundException("Technical not found"));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Technical technical) {
        return new ResponseEntity<>(technicalService.add(technical) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
