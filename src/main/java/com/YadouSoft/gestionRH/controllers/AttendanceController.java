package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.AbscentRepositories;
import com.YadouSoft.gestionRH.services.AttendanceService;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class AttendanceController {

    private AttendanceService attendanceService;
    private AbscentRepositories abscentRepositories;

    public AttendanceController(AttendanceService attendanceService, AbscentRepositories abscentRepositories) {
        this.attendanceService = attendanceService;
        this.abscentRepositories = abscentRepositories;
    }

    @GetMapping("/abscentes")
    public List<abscent> getallAbscent(){
        return attendanceService.getAllAbscent() ;
    }

    @GetMapping("/abscentesbycin/{cin}")
    public float getallAbscent(@PathVariable String cin){
        return attendanceService.getSumSup25byCin(cin) ;
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
