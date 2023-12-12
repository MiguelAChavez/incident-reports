package com.utn.report.incidentreport.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "technicals")
@AttributeOverride(name = "id", column = @Column(name = "technical_id"))
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Technical extends Person {

    @Column(nullable = false, name = "matriculation")
    private String matriculation;
/*
    @OneToMany(mappedBy = "technical", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Skill> skills;
*/

    public Technical(String name, String lastName, int dni, String matriculation) {
        super(name, lastName, dni);
        this.matriculation = matriculation;
    }

}
