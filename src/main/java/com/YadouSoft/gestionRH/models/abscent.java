package com.YadouSoft.gestionRH.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class abscent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;
    String first_in;
    String first_out;
    String last_in;
    String last_out;
    String total;
    String status;
    String shift;
    String date;
}
