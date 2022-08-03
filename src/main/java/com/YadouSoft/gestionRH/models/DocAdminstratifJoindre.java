package com.YadouSoft.gestionRH.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@NoArgsConstructor
public class DocAdminstratifJoindre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String copieDiplomes;
    private String copieCINE;
    private String copieCarteCNSS;
    private String fichAnthropométrique;
    private String radiographiePulmonaire;
    @OneToOne(mappedBy = "docAdminstratifJoindre")
    private Salarie salarie;

    public DocAdminstratifJoindre(String copieDiplomes, String copieCINE, String copieCarteCNSS, String fichAnthropométrique, String radiographiePulmonaire) {
        this.copieDiplomes = copieDiplomes;
        this.copieCINE = copieCINE;
        this.copieCarteCNSS = copieCarteCNSS;
        this.fichAnthropométrique = fichAnthropométrique;
        this.radiographiePulmonaire = radiographiePulmonaire;
    }
}

