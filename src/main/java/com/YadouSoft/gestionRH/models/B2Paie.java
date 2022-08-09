package com.YadouSoft.gestionRH.models;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Data
public class B2Paie implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer CNSS;
  private Integer AMO;
  private Integer HeuresSupp;
  private  Integer PrimeDanciennete;
  private  Integer PrimeDebilan;
  private  Integer PrimeDePanier;
  private  Integer PrimeDerendement;
  private  Integer IndemniteDeResponsabilite;
  private  Integer IndemniteDedeplacement;
  private  Integer IndemniteDeTransport;
  private  Integer SalaireBrutImposable;
  private  Integer NetImposable;
  private  Integer IR;
  private  Integer SalaireNet;
  private  String name;
  //@JsonIgnore
  //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @ToString.Exclude @EqualsAndHashCode.Exclude
  @ManyToOne()
  @JoinColumn(name = "salarie_id")
  private Salarie salarie;

  public B2Paie(Integer id, Integer CNSS, Integer AMO, Integer heuresSupp, Integer primeDanciennete, Integer primeDebilan, Integer primeDePanier, Integer primeDerendement, Integer indemniteDeResponsabilite, Integer indemniteDedeplacement, Integer indemniteDeTransport, Integer salaireBrutImposable, Integer netImposable, Integer IR, Integer salaireNet,String name, Salarie salarie) {
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
