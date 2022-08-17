package com.YadouSoft.gestionRH.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class DocAdminstratifJoindre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String copieDiplome;
    @Column(length = 1000000)
    private byte[] picByteDiplome;
    private String copieCINE;
    @Column(length = 1000000)
    private byte[] picByteCINE;
    private String copieCarteCNSS;
    @Column(length = 1000000)
    private byte[] picByteCNSS;
    private String fichAnthropométrique;
    @Column(length = 1000000)
    private byte[] picByteFichAnthropométrique;
    private String radiographiePulmonaire;
    @Column(length = 1000000)
    private byte[] picByteRadiographiePulmonaire;
    @OneToOne
    @ToString.Exclude @EqualsAndHashCode.Exclude
    @JoinColumn(name = "salarie_id")
    private Salarie salarie;



}

