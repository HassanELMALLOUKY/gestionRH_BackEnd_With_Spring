package com.YadouSoft.gestionRH.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Attendance {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   Long id;
   String date;
   String check_in;
   String breakk;
   String check_out;
   float hours;
   String status;
   String details;
     }
