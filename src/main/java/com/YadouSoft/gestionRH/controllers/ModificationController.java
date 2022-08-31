package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Modification;
import com.YadouSoft.gestionRH.services.ModificationService;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModificationController {
    private SalarieService salarieService;
    private ModificationService modificationService;

    public ModificationController(SalarieService salarieService, ModificationService modificationService) {
        this.salarieService = salarieService;
        this.modificationService = modificationService;
    }
    @GetMapping("modifications")
    public List<Modification> getModifications() {
        return modificationService.getModifications();
    }
    @PostMapping("/modifications")
    public void postModifications(@RequestBody Modification modification) {
        modificationService.saveModification(modification);
    }
}
