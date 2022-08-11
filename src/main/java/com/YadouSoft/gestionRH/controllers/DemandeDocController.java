package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.DemandeDoc;
import com.YadouSoft.gestionRH.services.DemandeDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("DemandeDoc")
public class DemandeDocController {

    @Autowired
    DemandeDocService demandeDocService;

    @GetMapping("/all")
    public List<DemandeDoc> getAllDemandeDocs(){
        return demandeDocService.getAllDemandeDocs();
    }

    @GetMapping("/all/desc")
    public List<DemandeDoc> findAllByOrderByIdDesc(){
        return demandeDocService.findAllByOrderByIdDesc();
    }

    @PostMapping("add")
    public DemandeDoc saveDemandeDoc(@RequestBody DemandeDoc demandeDoc) {
        return demandeDocService.saveDemandeDoc(demandeDoc);
    }

    @PatchMapping("/{id}")
    public DemandeDoc updateDemandeDoc(@RequestBody DemandeDoc demandeDoc, @PathVariable(name = "id") Long demandeDocId) {
        return demandeDocService.updateDemandeDoc(demandeDoc,demandeDocId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDemandeDoc(@PathVariable(name = "id") Long demandeDocId){
        demandeDocService.deleteDemandeDoc(demandeDocId);
        return "deleted ";
    }

    @GetMapping("/salarie/{id}")
    public List<DemandeDoc> demandeDocByPersonne(@PathVariable(name = "id") Integer id) {
        return demandeDocService.demandeDocByPersonne(id);
    }
}
