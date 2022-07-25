package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    private SalarieService salarieService;
    public TestController(SalarieService salarieService) {
        this.salarieService = salarieService;
    }

    @GetMapping("salarie/{id}")
    public Salarie getSalarie(@PathVariable long id){
        return salarieService.getSalarieById(id);
    }
    @GetMapping("salarieCINE/{cine}")
    public Salarie getSalarieByCINE(@PathVariable String cine){
        return salarieService.getSalarieByCINE(cine);
    }
    @GetMapping("salaries")
    public List<Salarie> getAllSalaries(){
        return salarieService.getAllSalaries();
    }
}
