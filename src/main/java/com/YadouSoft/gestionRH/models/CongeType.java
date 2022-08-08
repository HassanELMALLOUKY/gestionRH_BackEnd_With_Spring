package com.YadouSoft.gestionRH.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CongeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leave_name;

    private String type;// Paid or Unpaid
    private String leave_unit;// Days or Hours
    private String status; // Active or Deactive
    private String note;

}
