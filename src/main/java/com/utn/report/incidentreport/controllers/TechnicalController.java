package com.utn.report.incidentreport.Controllers;

import com.utn.report.incidentreport.Entity.Technical;
import com.utn.report.incidentreport.Services.Implementations.TechnicalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technical")
public class TechnicalController {
    @Autowired
    private TechnicalServiceImp technicalController;

    @GetMapping("/all")
    public List<Technical> getAll() {
        return technicalController.findAll();
    }

    @GetMapping("/{id}")
    public Technical getById(@PathVariable Long id) {
        return technicalController.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Technical technical) {
        return new ResponseEntity<>(technicalController.add(technical) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
