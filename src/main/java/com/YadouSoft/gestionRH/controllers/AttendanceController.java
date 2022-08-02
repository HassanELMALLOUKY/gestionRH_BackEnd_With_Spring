package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Attendance;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.services.AttendanceService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/abscentes")
    public List<abscent> getallAbscent(){
        return attendanceService.getAllAbscent() ;
    }
    @PostMapping("/abscentes")
    public void addAbscent(@RequestBody abscent abcsent){
         attendanceService.addAbscent(abcsent);
    }
    //delete the post
    @DeleteMapping("/abscentes/{id}")
    public void delete(@PathVariable Long id) {
        attendanceService.deleteAbscent(id);
    }



}
