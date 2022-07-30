package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Attendance;
import com.YadouSoft.gestionRH.services.AttendanceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
public class AttendanceController {

    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
@GetMapping("/Attendances")
public List<Attendance> getallAttendance(){
    return attendanceService.getAllAttendance() ;
}



}
