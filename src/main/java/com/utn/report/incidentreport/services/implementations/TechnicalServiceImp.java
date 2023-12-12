package com.utn.report.incidentreport.Services.Implementations;

import com.utn.report.incidentreport.Entity.Technical;
import com.utn.report.incidentreport.Repository.UserRepository;
import com.utn.report.incidentreport.Services.Interfaces.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalServiceImp implements PersonServices<Technical> {

    @Autowired
    private UserRepository technicalRepository;

    @Override
    public Boolean add(Technical technical) {
        boolean exist = false;
        try {
            technicalRepository.save(technical);
            exist = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return exist;
    }

    @Override
    public Boolean update(Technical technical) {
        return null;
    }

    @Override
    public void delete(Long id) {

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
