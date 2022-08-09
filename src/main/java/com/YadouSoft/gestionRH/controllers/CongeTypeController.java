package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.CongeType;
import com.YadouSoft.gestionRH.services.CongeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/type")
public class CongeTypeController {
    @Autowired
    private CongeTypeService congeTypeService;
    @GetMapping()
    public List<CongeType> fetchAllCongeType(){
        return congeTypeService.fetchAllCongeType();
    }

    @GetMapping("/{id}")
    public CongeType fetchOneCongeType(@PathVariable(name = "id") Long id){
        return congeTypeService.fetchOneCongeType(id);
    }

    @PostMapping()
    public CongeType saveCongeType(@RequestBody CongeType congeType){
        return congeTypeService.saveCongeType(congeType);
    }

    @PatchMapping("/{id}")
    public CongeType updateCongeType(@RequestBody CongeType congeType, @PathVariable(name = "id") Long id){
        congeType.setId(id);
        return congeTypeService.updateCongeType(
                congeType, id
        );
    }
    @DeleteMapping("/{id}")
    public String deleteCongeType(@PathVariable(name = "id") Long id){
        congeTypeService.deleteCongeType(id);
        return "Deleted Successfully !";
    }
}
