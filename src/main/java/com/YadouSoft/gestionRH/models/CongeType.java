package com.YadouSoft.gestionRH.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CongeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_name")
    private String leave_name;
    @Column(name = "type")
    private String type;// Paid or Unpaid
    private String leave_unit;// Days or Hours
    private String status; // Active or Deactive
    private String note;

    public CongeType(String leave_name, String type, String leave_unit, String status, String note) {
        this.leave_name = leave_name;
        this.type = type;
        this.leave_unit = leave_unit;
        this.status = status;
        this.note = note;
    }
}
