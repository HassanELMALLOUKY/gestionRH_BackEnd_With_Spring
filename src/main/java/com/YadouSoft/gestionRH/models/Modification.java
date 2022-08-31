package com.YadouSoft.gestionRH.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String attributs;
    private String mortif;
    private Boolean traiter;
    @ManyToOne
    private Salarie salarie;

}
