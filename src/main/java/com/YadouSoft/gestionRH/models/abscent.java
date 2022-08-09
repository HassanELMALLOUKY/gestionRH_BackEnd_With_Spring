package com.YadouSoft.gestionRH.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class abscent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;
    String cin;
    String first_in;
    String first_out;
    String last_in;
    String last_out;
    float total;
    String status;
    String shift;
    String type;
    String sup1_in;
    String sup1_out;
    String nbr_h_par_jour_sup1;
    String sup2_in;
    String sup2_out;
    String nbr_h_par_jour_sup2;
    float nbr_h_absence;
    float sup25;
    float sup50;
    float sup100;

    @Temporal(TemporalType.DATE)
    Date date;
}
