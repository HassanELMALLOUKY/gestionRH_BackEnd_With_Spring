package com.YadouSoft.gestionRH.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_debut")
    private String date_debut;
    @Column(name = "date_fin")
    private String date_fin;
    @Column(name = "type")
    private String type;
    @Column(name = "motif")
    private String motif;
    @Column(name = "status")
    private String status;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Salarie salarie;

    public Conge(String date_debut, String date_fin, String type, String motif, String status) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
        this.motif = motif;
        this.status = status;
    }
}
