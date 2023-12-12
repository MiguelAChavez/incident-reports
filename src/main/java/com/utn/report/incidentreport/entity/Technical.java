package com.utn.report.incidentreport.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "technicals")
@AttributeOverride(name = "id", column = @Column(name = "technical_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Technical extends Person {

    @Column(nullable = false, name = "matriculation")
    private String matriculation;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ability_id", referencedColumnName = "ability_id")
    private List<Ability> Skills;
*/

    public Technical(String name, String lastName, int dni, String matriculation) {
        super(name, lastName, dni);
        this.matriculation = matriculation;
    }

}
