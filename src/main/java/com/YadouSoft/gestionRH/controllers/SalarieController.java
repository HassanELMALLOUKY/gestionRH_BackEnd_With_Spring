package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/salaries")
public class SalarieController {
    private SalarieService salarieService;

    public SalarieController(SalarieService salarieService) {
        this.salarieService = salarieService;
    }
    //Obtenir les info d'un salarié
    @GetMapping("/{id}")
    public Salarie getSalarieByCINE(@PathVariable long id){

        return salarieService.getSalarieById(id);
    }
    //Ajouter un salarié
    @PostMapping("")
    public Salarie saveSalarie(@RequestBody Salarie salarie){

        return salarieService.addSalarie(salarie);
    }
    //Obtenir les info de tous les salariés
    @GetMapping("")
    public List<Salarie> getAllSalaries(){

        return salarieService.getAllSalaries();
    }
    //modifier les info d'un salarié
    @PutMapping("/{id}")
    public Salarie updateSalarieByCINE(@PathVariable long id, @RequestBody Salarie salarie){
        Salarie s=salarieService.getSalarieById(id);
        s.setNom(salarie.getNom());
        s.setPrenom(salarie.getPrenom());
        s.setAdresse(salarie.getAdresse());
        s.setContrat(salarie.getContrat());
        s.setDateDepart(salarie.getDateDepart());
        s.setDateNaissance(salarie.getDateNaissance());
        s.setEmail(salarie.getEmail());
        s.setMatriculeCNSS(salarie.getMatriculeCNSS());
        s.setNomBanque(salarie.getNomBanque());
        s.setNombreEnfants(salarie.getNombreEnfants());
        s.setRIB(salarie.getRIB());
        s.setRole(salarie.getRole());
        s.setTele(salarie.getTele());
        s.setMotifDepart(salarie.getMotifDepart());

        return salarieService.addSalarie(s);
    }
    //supprimer un salarié
    @DeleteMapping("/{id}")
    public List<Salarie> deleteSalarieByCINE(@PathVariable long id){

        return salarieService.deleteSalarieById(id);
    }
}
