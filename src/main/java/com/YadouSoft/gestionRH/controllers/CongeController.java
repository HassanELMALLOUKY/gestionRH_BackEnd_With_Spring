package com.YadouSoft.gestionRH.controllers;


import com.YadouSoft.gestionRH.beens.CongeInfo;
import com.YadouSoft.gestionRH.enums.Statut;
import com.YadouSoft.gestionRH.models.Conge;
import com.YadouSoft.gestionRH.services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/conge")
public class CongeController {
    @Autowired
    private CongeService congeService;

    @GetMapping()
    public List<Conge> fetchAllConge(){
        return congeService.fetchAllConge();
    }

    @GetMapping("/{id}")
    public Conge fetchOneConge(@PathVariable(name = "id") Long id){
        return congeService.fetchOneConge(id);
    }

    @PostMapping()
    public Conge saveConge(@RequestBody Conge conge){
        return congeService.saveConge(conge);
    }

    @PatchMapping("/{id}")
    public Conge updateConge(@RequestBody Conge conge, @PathVariable(name = "id") Long id){
        conge.setId(id);
        return congeService.updateConge(
                conge, id
        );
    }
    @DeleteMapping("/{id}")
    public String deleteConge(@PathVariable(name = "id") Long id){
        congeService.deleteConge(id);
        return "Deleted Successfully !";
    }


    @GetMapping("/salarie/{salarie}")
    public List<Conge> CongesByPersonne(@PathVariable(name = "salarie") String CIN){
        return congeService.CongesByPersonne(CIN);
    }

    @GetMapping("/touts")
    public List<CongeInfo> getAllCongeInfo(){
        return congeService.getAllCongeInfo();
    }

    // status accept just [Approved, Pending, Rejected ] ,I well used for Pending leave request :::
    @GetMapping("/entraitment/{status}")
    public List<Conge> getCongesByStatus(@PathVariable(name = "status") String status){
        return congeService.getCongesByStatus(Statut.valueOf(status));
    }
}
