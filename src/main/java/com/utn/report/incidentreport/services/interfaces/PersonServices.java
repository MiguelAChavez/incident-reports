package com.utn.report.incidentreport.services.interfaces;

import com.utn.report.incidentreport.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonServices<T extends Person> {
    public Boolean add(T t);

    public Boolean update(T t);

    public void delete(Long id);

    public List<T> findAll();

    public Optional<T> findById(Long id);

    public Optional<T> findByDni(int dni);

}
