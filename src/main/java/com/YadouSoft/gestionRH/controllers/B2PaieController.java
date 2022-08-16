package com.YadouSoft.gestionRH.controllers;


import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.services.B2PaieService;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("b2Paies/")
public class B2PaieController {
    private B2PaieService b2PaieService;
    private  B2Paie b2Paie;
    @Autowired
    private SalarieService salarieService;
    public B2PaieController(B2PaieService b2PaieService){
        this.b2PaieService=b2PaieService;
    }
    @GetMapping("/b2paie/{id}")
    public B2Paie getFicheById(@PathVariable long id){

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
    @PutMapping("/{id}")
    public B2Paie updateFichep(@RequestBody B2Paie b2Paie, @PathVariable(name = "id") long id){
        b2Paie.setId(id);
        return b2PaieService.updateFicheP(
                b2Paie, id
        );
    }
    @GetMapping("/salarie")
    public List<Salarie> getsalByb2(){
        return b2PaieService.getsalByb2();
    }
    @GetMapping( "/salarie/{id}")
    public B2Paie getsalByb2(@PathVariable long id){
        return b2PaieService.findByEmployee_Id(id);
    }

    @DeleteMapping("b2paie/delete/{id}")
    public B2Paie deleteFicheById(@PathVariable long id){

        return b2PaieService.deleteFicheP(id);
    }
    @GetMapping("/find/{id}")
    public Salarie getInfo( @PathVariable long id){
        return b2PaieService.getsalarieInfo(id);
       // Integer salarie=getFicheById(5).getSalarie().getId();
     // return b2PaieService.getsalarieInfo(salarie);
    }
        @GetMapping("/calcul/{id}")
    public B2Paie calculer( @PathVariable long id){
        return b2PaieService.SettingData(id);
        // Integer salarie=getFicheById(5).getSalarie().getId();
        // return b2PaieService.getsalarieInfo(salarie);
    }

}
