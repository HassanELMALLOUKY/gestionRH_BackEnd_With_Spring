package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.services.AttendanceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }




}
