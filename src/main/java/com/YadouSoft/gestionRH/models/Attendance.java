package com.YadouSoft.gestionRH.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attendance {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   Long id;
   String img;
   String name;
   String first_in;
   String first_out;
   String last_in;
   String last_out;
   String total;
   String status;
   String shift;
     }

 class fromTo{
   String from;
   String To;
 }
