package com.YadouSoft.gestionRH.controllers;


import com.YadouSoft.gestionRH.models.Conge;
import com.YadouSoft.gestionRH.services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
