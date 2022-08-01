package com.YadouSoft.gestionRH.beens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongeInfo {
    private String salarieName;
    private String type;
    private String date_debut;
    private String date_fin;
    private String demi_journee;
    private String status;
    private String motif;
}
