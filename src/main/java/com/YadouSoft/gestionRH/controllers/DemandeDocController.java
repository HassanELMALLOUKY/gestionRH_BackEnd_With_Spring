package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.DemandeDoc;
import com.YadouSoft.gestionRH.services.DemandeDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DemandeDocController {

    @Autowired
    DemandeDocService demandeDocService;

    @GetMapping("/all")
    public List<DemandeDoc> getAllDemandeDocs(){
        return demandeDocService.getAllDemandeDocs();
    }

    @PostMapping("add")
    public DemandeDoc saveDemandeDoc(@RequestBody DemandeDoc demandeDoc) {
        return demandeDocService.saveDemandeDoc(demandeDoc);
    }
}
