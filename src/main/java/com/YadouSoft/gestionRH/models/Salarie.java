package com.YadouSoft.gestionRH.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenerationTime;
import javax.annotation.Generated;
import javax.persistence.*;
import java.io.DataOutput;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Salarie implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private  Integer salaireBase;
    private String prenom;
    @Formula("nom+prenom")
    private String fullName;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Formula("YEAR(CURDATE())-YEAR(date_naissance)")    private String age;
    @Column(length = 1000000)
    private byte[] photo;
    private String CINE;
    private String adresse;
    private String tele;
    @Column(unique = true)
    private String email;
    private String matriculeCNSS;
    @Formula("CEIL((DATEDIFF(CURDATE(), date_depart))/365)")
    private double anciennete;
    private String nomBanque;
    private double RIB;
    private int nombreEnfants;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    private String motifDepart;
    private String role;
    private Boolean marie;
    private Double tauxNormal;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToOne()
    private DocAdminstratifJoindre docAdminstratifJoindre;

    @JsonIgnore
   // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie" )
    private Collection <B2Paie> b2Paies;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Conge.class, mappedBy = "salarie")
    private Collection<Conge> congeCollection;
    
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie")
    private Collection <DemandeDoc> demandeDocs;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie")
    private Collection<abscent> abscents;



}
