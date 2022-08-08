package com.YadouSoft.gestionRH.controllers;


import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.services.B2PaieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("b2Paies/")
public class B2PaieController {
    private B2PaieService b2PaieService;
    public B2PaieController(B2PaieService b2PaieService){
        this.b2PaieService=b2PaieService;
    }
    @GetMapping("/b2paie/{id}")
    public B2Paie getSalarieById(@PathVariable Integer id){

        return b2PaieService.getFicheP(id);
    }
    @PostMapping("b2paie/addfiche")
    public B2Paie addFicheP(@RequestBody B2Paie b2Paie){

        return b2PaieService.addFicheP(b2Paie);
    }
    @GetMapping("b2paie/all")
    public List<B2Paie> getAllFicheP(){

        return b2PaieService.getAllFicheP();
    }
    @DeleteMapping("b2paie/delete/{id}")
    public B2Paie deleteFicheById(@PathVariable Integer id){

        return b2PaieService.deleteFicheP(id);
    }
}
