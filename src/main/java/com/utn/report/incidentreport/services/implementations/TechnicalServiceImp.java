package com.utn.report.incidentreport.services.implementations;

import com.utn.report.incidentreport.entity.Technical;
import com.utn.report.incidentreport.exceptions.TechnicalValidationException;
import com.utn.report.incidentreport.repository.UserRepository;
import com.utn.report.incidentreport.services.interfaces.PersonServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TechnicalServiceImp implements PersonServices<Technical> {
    private final UserRepository technicalRepository;

    @Autowired
    public TechnicalServiceImp(UserRepository technicalRepository) {
        this.technicalRepository = technicalRepository;
    }

    @Override
    public Boolean add(Technical technical) {
        try {
            var t = technicalRepository.save(technical);
            log.info(t.toString());
            return true;
        } catch (TechnicalValidationException e) {
            throw new TechnicalValidationException(HttpStatus.BAD_REQUEST, "Technical already exists");
        }
    }

    @Override
    public Boolean update(Technical technical) {
        return false;
    }

    @Override
    public void delete(Long id) {
        if (id == null || id <= 0) {
            throw new TechnicalValidationException(HttpStatus.BAD_REQUEST, "Technical id can't be null or less than 0");
        }
        technicalRepository.deleteById(id);
    }

    @Override
    public List<Technical> findAll() {
        return technicalRepository.findAll();
    }

    @Override
    public Optional<Technical> findById(Long id) {
        return technicalRepository.findById(id);
    }

    @Override
    public Optional<Technical> findByDni(int dni) {
        return technicalRepository.findByDni(dni);
    }

}
