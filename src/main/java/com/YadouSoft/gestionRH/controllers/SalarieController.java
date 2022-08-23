package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.*;
import com.YadouSoft.gestionRH.services.DocAdministratifJoindreService;
import com.YadouSoft.gestionRH.services.RoleService;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("api/salaries")
@CrossOrigin("*")
public class SalarieController {

    private SalarieService salarieService;
    private DocAdministratifJoindreService docAdministratifJoindreService;
    private RoleService roleService;

    public SalarieController(SalarieService salarieService, DocAdministratifJoindreService docAdministratifJoindreService, RoleService roleService) {
        this.salarieService = salarieService;
        this.docAdministratifJoindreService = docAdministratifJoindreService;
        this.roleService = roleService;
    }
    //Obtenir les info d'un salarié
    @GetMapping("/{id}")
    public DocAdminstratifJoindre getSalarieById(@PathVariable long id){
        return salarieService.getSalarieById(id).getDocAdminstratifJoindre();
    }

    @GetMapping("/cine/{cine}")
    public Salarie getSalarieByCINE(@PathVariable String cine){

        return salarieService.getSalarieByCINE(cine);
    }
    //Ajouter un salarié
    @PostMapping("/{role}")
    @PreAuthorize("hasAnyAuthority('Superviseur','Admin')")
    public Salarie saveSalarie(@RequestBody Salarie salarie,@PathVariable("role") String role){
        Role role1=roleService.getRoleByName(role);
        salarie.getRoles().add(role1);
        return salarieService.addSalarie(salarie);
    }
    //Obtenir les info de tous les salariés
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('Superviseur','Documenteur','Paie','Admin')")
    public List<Salarie> getAllSalaries(){

        return salarieService.getAllSalaries();
    }
    @GetMapping("/names")
    @PreAuthorize("hasAnyAuthority('Basic')")
    public List<String> getAllSalariesNames(){
        List<String> list = new ArrayList<String>();
        salarieService.getAllSalaries().forEach(salarie->{
            list.add(salarie.getNom()+" "+salarie.getPrenom());
        });
        return list;
    }
    @GetMapping("/names/{nom}&{prenom}")
    public Salarie getSalarieByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom){
        return salarieService.getSalarieByNomAndPrenom(nom, prenom);
    }
    //modifier les info d'un salarié
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Superviseur')")
    public Salarie updateSalarieById(@PathVariable long id, @RequestBody Salarie salarie){
        Salarie s=salarieService.getSalarieById(id);
        s.setNom(salarie.getNom());
        s.setPrenom(salarie.getPrenom());
        s.setAdresse(salarie.getAdresse());
        s.setDateDepart(salarie.getDateDepart());
        s.setDateNaissance(salarie.getDateNaissance());
        s.setEmail(salarie.getEmail());
        s.setMatriculeCNSS(salarie.getMatriculeCNSS());
        s.setNomBanque(salarie.getNomBanque());
        s.setNombreEnfants(salarie.getNombreEnfants());
        s.setRib(salarie.getRib());
        s.setMarie(salarie.getMarie());
        s.setTauxNormal(salarie.getTauxNormal());
        s.setTele(salarie.getTele());
        s.setMotifDepart(salarie.getMotifDepart());
        return salarieService.addSalarie(s);
    }
    //supprimer un salarié
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Admin','Superviseur')")
    public List<Salarie> deleteSalarieByCINE(@PathVariable long id){

        return salarieService.deleteSalarieById(id);
    }
    @GetMapping("/abs/{id}")
    public Collection<abscent> getAbs(@PathVariable long id){
        return salarieService.getSalarieById(id).getAbscents();
    }

    @GetMapping("/rest")
    public List<Salarie> getRestSalaries(){
        return salarieService.getRestSalaries();
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasAnyAuthority('Admin','Basic','Documenteur','Paie','Superviseur')")
    public Salarie getSalarieByUsername(@PathVariable String username){
        return salarieService.loadUserByUsername(username);
    }
}
