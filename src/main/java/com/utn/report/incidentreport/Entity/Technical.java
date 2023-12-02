package com.utn.report.incidentreport.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Matriculation is required")
    @Pattern(regexp = "^[0-9]{4}-[a-zA-Z]{2}$", message = "Matriculation must be in format 0000-AA")
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
