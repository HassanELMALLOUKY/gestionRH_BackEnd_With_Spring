package com.YadouSoft.gestionRH.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class DemandeDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String typeDemande;
    private Date dateDemande;
    private boolean status;
    private String reponse;

    @ManyToOne
    private Salarie salarie;

    public DemandeDoc(Long id, String nom, String typeDemande, Date dateDemande, boolean status, String reponse, Salarie salarie) {
        this.id = id;
        this.nom = nom;
        this.typeDemande = typeDemande;
        this.dateDemande = dateDemande;
        this.status = status;
        this.reponse = reponse;
        this.salarie = salarie;
    }
}
