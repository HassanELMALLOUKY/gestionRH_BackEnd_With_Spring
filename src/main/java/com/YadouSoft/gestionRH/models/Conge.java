package com.YadouSoft.gestionRH.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    private Date date_debut;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private Date date_fin;
    @Column(name = "type")
    private String type;
    @Column(name = "motif")
    private String motif;
    @Column(name = "status")
    private String status;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(fetch=FetchType.LAZY)
    private Salarie salarie;

    public Conge(Date date_debut, Date date_fin, String type, String motif, String status) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type = type;
        this.motif = motif;
        this.status = status;
    }
}
