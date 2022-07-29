package com.YadouSoft.gestionRH.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Salarie{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    @Id
    private String CINE;
    private String adresse;
    private String tele;
    @Column(unique = true)
    private String email;
    private String role;
    private String matriculeCNSS;
    private String nomBanque;
    private String RIB;
    private int nombreEnfants;
    private Date dateDepart;
    private String motifDepart;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToOne()
    private DocAdminstratifJoindre docAdminstratifJoindre;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToOne()
    private Contrat contrat;
    @OneToMany(mappedBy = "salarie")
    private Collection <B2Paie> b2Paies;
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(targetEntity = Conge.class, mappedBy = "salarie")
    private Collection<Conge> congeCollection;
    
    @JsonIgnore
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "salarie")
    private Collection <DemandeDoc> demandeDocs;

    public Salarie(long id, String nom, String prenom, Date dateNaissance, String CINE, String adresse, String tele, String email, String role, String matriculeCNSS, String nomBanque, String RIB, int nombreEnfants, Date dateDepart, String motifDepart, DocAdminstratifJoindre docAdminstratifJoindre, Contrat contrat, Collection<B2Paie> b2Paies, Collection<DemandeDoc> demandeDocs) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.CINE = CINE;
        this.adresse = adresse;
        this.tele = tele;
        this.email = email;
        this.role = role;
        this.matriculeCNSS = matriculeCNSS;
        this.nomBanque = nomBanque;
        this.RIB = RIB;
        this.nombreEnfants = nombreEnfants;
        this.dateDepart = dateDepart;
        this.motifDepart = motifDepart;
        this.docAdminstratifJoindre = docAdminstratifJoindre;
        this.contrat = contrat;
        this.b2Paies = b2Paies;
        this.demandeDocs = demandeDocs;
    }
    public Salarie(String nom, String prenom, Date dateNaissance, String CINE, String adresse, String tele, String email, String role, String matriculeCNSS, String nomBanque, String RIB, int nombreEnfants, Date dateDepart, String motifDepart) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.CINE = CINE;
        this.adresse = adresse;
        this.tele = tele;
        this.email = email;
        this.role = role;
        this.matriculeCNSS = matriculeCNSS;
        this.nomBanque = nomBanque;
        this.RIB = RIB;
        this.nombreEnfants = nombreEnfants;
        this.dateDepart = dateDepart;
        this.motifDepart = motifDepart;
    }

}