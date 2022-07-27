package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class SalarieController {
    private SalarieService salarieService;

    public SalarieController(SalarieService salarieService) {
        this.salarieService = salarieService;
    }
    //Obtenir les info d'un salarié
    @GetMapping("salaries/{cine}")
    public Salarie getSalarieByCINE(@PathVariable String cine){

        return salarieService.getSalarieByCINE(cine);
    }
    //Ajouter un salarié
    @PostMapping("salaries")
    public Salarie saveSalarie(@RequestBody Salarie salarie){

        return salarieService.addSalarie(salarie);
    }
    //Obtenir les info de tous les salariés
    @GetMapping("salaries")
    public List<Salarie> getAllSalaries(){

        return salarieService.getAllSalaries();
    }
    //modifier les info d'un salarié
    @PutMapping("salaries/{cine}")
    public Salarie updateSalarieByCINE(@PathVariable String cine, @RequestBody Salarie salarie){
        Salarie s=salarieService.getSalarieByCINE(cine);
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
    @DeleteMapping("salaries/{cine}")
    public Salarie deleteSalarieByCINE(@PathVariable String cine){

        return salarieService.deleteSalarieByCINE(cine);
    }
}
