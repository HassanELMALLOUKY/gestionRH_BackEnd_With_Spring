package com.YadouSoft.gestionRH.models;

import com.YadouSoft.gestionRH.enums.Statut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Conge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    private Date from;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private Date leaveTo;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_demande")
    private Date applyDate;// LocalDateTime now = LocalDateTime.now();

    @Column(name = "demi_journee")
    private String noOfDays;
    @Column(name = "type")
    private String type;
    @Column(name = "motif")
    private String reason;
    @Column(name = "admin_reponse")
    private String reponse;
    @Column(name = "status")
    private Statut status;
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne
    private Salarie salarie;
    @Column(name = "sold")
    private String sold;
    // Pending or Approved or Rejected




    public Conge(Date from, Date leaveTo, Date applyDate, String noOfDays, String type, String reason, Statut status, String sold, Salarie salarie) {
        this.from = from;
        this.leaveTo = leaveTo;
        this.applyDate = applyDate;
        this.noOfDays = noOfDays;
        this.type = type;
        this.reason = reason;
        this.status = status;
        this.sold = sold;
        this.salarie = salarie;
    }
}
