package com.YadouSoft.gestionRH;

import com.YadouSoft.gestionRH.models.Attendance;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.services.AttendanceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionRhApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionRhApplication.class, args);
    }


    @Bean
    CommandLineRunner start(AttendanceService attendanceService) {
        return args -> {
         //   attendanceService.addAbscent(new abscent(null, "8:00", "1:08", "19:19", "present", "justifier"));
         //   attendanceService.addAbscent(new abscent(null, "8:00", "1:08", "19:19", "present", "justifier"));

//      accountServices.addNewRole(new userRole(null,"admin"));
//      accountServices.addNewRole(new userRole(null,"user"));
//      accountServices.addNewRole(new userRole(null,"manager"));
//      accountServices.addRoleToUser("rachidrachid","admin");
//      accountServices.addRoleToUser("hassanhassan","user");
//      accountServices.addRoleToUser("brahimbrahim","manager");


        };


    }
}
