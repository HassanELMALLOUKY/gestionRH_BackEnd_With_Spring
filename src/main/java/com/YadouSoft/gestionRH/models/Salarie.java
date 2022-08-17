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
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private  Integer salaireBase;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(nullable = false)
    @Formula("YEAR(CURDATE())-YEAR(date_naissance)")
    private String age;
    @Column(nullable = false)
    private String CINE;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String tele;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String matriculeCNSS;
    @Formula("CEIL((DATEDIFF(CURDATE(), date_depart))/365)")
    private String anciennete;
    private String nomBanque;
    @Column(nullable = false)
    private double rib;
    @Column(nullable = false)
    private int nombreEnfants=0;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    private String motifDepart;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private Boolean marie;
    @Column(nullable = false)
    private Double tauxNormal;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "salarie", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DocAdminstratifJoindre docAdminstratifJoindre;

    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie",cascade = CascadeType.ALL)
    private Collection <B2Paie> b2Paies;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Conge.class, mappedBy = "salarie", cascade = CascadeType.ALL)
    private Collection<Conge> congeCollection;
    
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie",cascade = CascadeType.ALL)
    private Collection <DemandeDoc> demandeDocs;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie",cascade = CascadeType.ALL)
    private Collection<abscent> abscents;



}
