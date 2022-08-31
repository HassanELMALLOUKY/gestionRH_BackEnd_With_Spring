package com.YadouSoft.gestionRH.controllers;


import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.repositories.B2PaieRepository;
import com.YadouSoft.gestionRH.services.B2PaieService;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("b2Paies/")
public class B2PaieController {
    private B2PaieService b2PaieService;
    @Autowired
    private B2PaieRepository b2PaieRepository;
    private  B2Paie b2Paie;

    @Autowired
    private SalarieService salarieService;
    public B2PaieController(B2PaieService b2PaieService){
        this.b2PaieService=b2PaieService;
    }
    @GetMapping("/b2paie/{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Paie')")
    public B2Paie getFicheById(@PathVariable long id){

        return b2PaieService.getFicheP(id);
    }
    @PostMapping("b2paie/addfiche")

    @PreAuthorize("hasAnyAuthority('Admin','Paie')")
    public B2Paie addFicheP(@RequestBody B2Paie b2Paie){

        return b2PaieService.addFicheP(b2Paie);
    }
    @GetMapping("b2paie/all")

    @PreAuthorize("hasAnyAuthority('Admin','Paie')")
    public List<B2Paie> getAllFicheP(){

        return b2PaieService.getAllFicheP();
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Paie')")

    public B2Paie updateFichep(@RequestBody B2Paie b2Paie, @PathVariable(name = "id") long id){
        b2Paie.setId(id);
        return b2PaieService.updateFicheP(
                b2Paie, id
        );
    }
    @GetMapping("/bulletin/{username}")

    @PreAuthorize("hasAnyAuthority('Admin','Paie','Basic')")

    public List<B2Paie> getsalByb2(@PathVariable String username){
        return b2PaieRepository.getBulletinByUsername(username);
    }
    @GetMapping( "/salarie/{id}")

    @PreAuthorize("hasAnyAuthority('Admin','Paie')")

    public B2Paie getsalByb2(@PathVariable long id){
        return b2PaieService.findByEmployee_Id(id);
    }

    @DeleteMapping("b2paie/delete/{id}")

    @PreAuthorize("hasAnyAuthority('Admin','Paie')")

    public B2Paie deleteFicheById(@PathVariable long id){

        return b2PaieService.deleteFicheP(id);
    }
    @GetMapping("/find/{id}")

    @PreAuthorize("hasAnyAuthority('Admin','Paie')")

    public Salarie getInfo( @PathVariable long id){
        return b2PaieService.getsalarieInfo(id);
       // Integer salarie=getFicheById(5).getSalarie().getId();
     // return b2PaieService.getsalarieInfo(salarie);
    }
        @GetMapping("/calcul/{id}")

        @PreAuthorize("hasAnyAuthority('Admin','Paie')")

        public B2Paie calculer( @PathVariable long id){
        return b2PaieService.SettingData(id);
        // Integer salarie=getFicheById(5).getSalarie().getId();
        // return b2PaieService.getsalarieInfo(salarie);
    }

}
