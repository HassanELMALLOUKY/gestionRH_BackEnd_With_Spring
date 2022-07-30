package com.YadouSoft.gestionRH;

import com.YadouSoft.gestionRH.models.Attendance;
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
//            attendanceService.addAttendance(new Attendance(null, "12-10*2022", "8:00", "1:08", "19:19", 4, "present", "justifier"));
//            attendanceService.addAttendance(new Attendance(null, "13-10*2022", "8:00", "1:08", "19:19", 4, "abscent", "justifier"));

//      accountServices.addNewRole(new userRole(null,"admin"));
//      accountServices.addNewRole(new userRole(null,"user"));
//      accountServices.addNewRole(new userRole(null,"manager"));
//      accountServices.addRoleToUser("rachidrachid","admin");
//      accountServices.addRoleToUser("hassanhassan","user");
//      accountServices.addRoleToUser("brahimbrahim","manager");


        };


    }
}
