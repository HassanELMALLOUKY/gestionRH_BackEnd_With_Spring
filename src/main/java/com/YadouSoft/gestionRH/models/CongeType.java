package com.YadouSoft.gestionRH.models;

import com.YadouSoft.gestionRH.enums.TypeStatut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class CongeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_name")
    private String leave_name;
    @Column(name = "type")
    private String type;// Paid or Unpaid
    private String leave_unit;// Days or Hours
    private TypeStatut status;
    private String note;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Conge.class, mappedBy = "type", cascade = CascadeType.ALL)
    private Collection<Conge> congeCollection;

    public CongeType(String leave_name, String type, String leave_unit, TypeStatut status, String note) {
        this.leave_name = leave_name;
        this.type = type;
        this.leave_unit = leave_unit;
        this.status = status;
        this.note = note;
    }
}
