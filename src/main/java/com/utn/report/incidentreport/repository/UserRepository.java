package com.utn.report.incidentreport.Repository;

import com.utn.report.incidentreport.Entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Technical, Long> {
    Optional<Technical> findByDni(int dni);
}
