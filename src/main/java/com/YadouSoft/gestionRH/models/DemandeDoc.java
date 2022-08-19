package com.YadouSoft.gestionRH.models;


import com.YadouSoft.gestionRH.enums.Statut;
import lombok.*;

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
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Document requestType;
    private String requestDate;
    private Statut status;
    private String response;
    private String reason;
    @ManyToOne
    private Salarie salarie;


    public DemandeDoc(Long id, Document requestType, String requestDate, Statut status, String reason, String response, Salarie salarie) {
        this.id = id;
        this.requestType = requestType;
        this.requestDate = requestDate;
        this.status = status;
        this.reason = reason;
        this.response =response;
        this.salarie = salarie;

    }
}
