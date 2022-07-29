package com.YadouSoft.gestionRH.models;



import javax.persistence.*;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Data
public class B2Paie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer CNSS;
  private Integer AMO;
  private Integer HeuresSupp;
  private  Integer PrimeDancienneté;
  private  Integer PrimeDebilan;
  private  Integer PrimeDePanier;
  private  Integer PrimeDerendement;
  private  Integer IndemnitéDeResponsabilité;
  private  Integer IndemnitéDedéplacement;
  private  Integer IndemnitéDeTransport;
  private  Integer SalaireBrutImposable;
  private  Integer NetImposable;
  private  Integer IR;
  private  Integer SalaireNet;
  @JsonIgnore
  @ToString.Exclude @EqualsAndHashCode.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "salarie_id")
  private Salarie salarie;

  public B2Paie(Integer id, Integer CNSS, Integer AMO, Integer heuresSupp, Integer primeDancienneté, Integer primeDebilan, Integer primeDePanier, Integer primeDerendement, Integer indemnitéDeResponsabilité, Integer indemnitéDedéplacement, Integer indemnitéDeTransport, Integer salaireBrutImposable, Integer netImposable, Integer IR, Integer salaireNet, Salarie salarie) {
    this.id = id;
    this.CNSS = CNSS;
    this.AMO = AMO;
    this.HeuresSupp = heuresSupp;
    this.PrimeDancienneté = primeDancienneté;
    this.PrimeDebilan = primeDebilan;
    this.PrimeDePanier = primeDePanier;
    this.PrimeDerendement = primeDerendement;
    this.IndemnitéDeResponsabilité = indemnitéDeResponsabilité;
    this.IndemnitéDedéplacement = indemnitéDedéplacement;
    this.IndemnitéDeTransport = indemnitéDeTransport;
    this.SalaireBrutImposable = salaireBrutImposable;
    this.NetImposable = netImposable;
    this.IR = IR;
    this.SalaireNet = salaireNet;
    this.salarie = salarie;
  }

}
