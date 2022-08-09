package com.YadouSoft.gestionRH.models;


import com.YadouSoft.gestionRH.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class DemandeDoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cin;
    private String requestType;
    private String requestDate;
    private Statut status;
    private String response;
    private String reason;
    @ManyToOne
    private Salarie salarie;

    public DemandeDoc(Long id, String name, String requestType, String requestDate, Statut status, String reason, Salarie salarie) {
        this.id = id;
        this.name = name;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.status = status;
        this.reason = reason;
        this.salarie = salarie;

    }
}
