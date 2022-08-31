package com.YadouSoft.gestionRH.models;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
public class B2Paie implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Double CNSS;
  private Double AMO;
  private Double AssuranceM;
  private Double cimr;
  private Double fraisProf;
  private Double  Voituredefonction;
  private Double salaireBrut;
  private Double indemniteDeLogement;
  private Double eletexo;
  private Double HeuresSupp;
  private Double irBrut;
  private Integer chargeFamille;
  private  Double PrimeDanciennete;
  private Double prestationFamiliale;
  private Double prestationSociale;
  private Double formatioProf;
  private Double amoPatronale;
  private Double cimrPatronale;
  private Double mutuellePatronale;
  private  Integer PrimeDebilan;
  private  Integer PrimeDePanier;
  private  Integer PrimeDerendement;
  @Column(columnDefinition = "LONGTEXT")
  private String pdf;
  private  Integer IndemniteDeResponsabilite;
  private  Integer IndemniteDedeplacement;
  private  Integer IndemniteDeTransport;
  private  Double SalaireBrutImposable;
  private  Double NetImposable;
  private  Double IR;
  private  Double SalaireNet;
  private String username;
  private  String name;
  private Double Salairebase;
  private Double heurenormale;

  private LocalDate paiedatem;
 // @JsonIgnore
  //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @ToString.Exclude @EqualsAndHashCode.Exclude
  @ManyToOne()
  @JoinColumn(name = "salarie_id")
  private Salarie salarie;

  public B2Paie(Integer id, Double CNSS, Double AMO, Double heuresSupp, Double primeDanciennete, Integer primeDebilan, Integer primeDePanier, Integer primeDerendement, Integer indemniteDeResponsabilite, Integer indemniteDedeplacement, Integer indemniteDeTransport, Double salaireBrutImposable, Double netImposable, Double IR, Double salaireNet,String name, Salarie salarie) {
    this.id = id;
    this.CNSS = CNSS;
    this.AMO = AMO;
    this.HeuresSupp = heuresSupp;
    this.PrimeDanciennete = primeDanciennete;
    this.PrimeDebilan = primeDebilan;
    this.PrimeDePanier = primeDePanier;
    this.PrimeDerendement = primeDerendement;
    this.IndemniteDeResponsabilite = indemniteDeResponsabilite;
    this.IndemniteDedeplacement = indemniteDedeplacement;
    this.IndemniteDeTransport = indemniteDeTransport;
    this.SalaireBrutImposable = salaireBrutImposable;
    this.NetImposable = netImposable;
    this.IR = IR;
    this.SalaireNet = salaireNet;
    this.name=name;
    this.salarie = salarie;
  }

}
