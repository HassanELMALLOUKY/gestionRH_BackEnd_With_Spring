package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.*;
import com.YadouSoft.gestionRH.services.DocAdministratifJoindreService;
import com.YadouSoft.gestionRH.services.RoleService;
import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("api/salaries")
@CrossOrigin("http://localhost:4200/")
public class SalarieController {

    private SalarieService salarieService;
    private DocAdministratifJoindreService docAdministratifJoindreService;
    private RoleService roleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public SalarieController(SalarieService salarieService, DocAdministratifJoindreService docAdministratifJoindreService, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.salarieService = salarieService;
        this.docAdministratifJoindreService = docAdministratifJoindreService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        System.out.println("front end role: " + role);
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
    @PutMapping("/{id}/{role}")
    @PreAuthorize("hasAnyAuthority('Admin','Superviseur')")
    public Salarie updateSalarieById(@PathVariable(name = "id") long id, @RequestBody Salarie salarie,@PathVariable("role") String role){
        Role role1=roleService.getRoleByName(role);
        Salarie s=salarieService.getSalarieById(id);
        s.getRoles().removeAll(s.getRoles());
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
        s.getRoles().add(role1);
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

    @PostMapping("/change_password/{username}/{oldPassword}_{newPassword}")
    @PreAuthorize("hasAnyAuthority('Admin','Basic','Documenteur','Paie','Superviseur')")
    public boolean changePassword(@PathVariable String username,@PathVariable(name = "oldPassword") String oldPassword, @PathVariable("newPassword") String newPassword){
        Salarie salarie=salarieService.loadUserByUsername(username);
        System.out.println("real old password: "+salarie.getPassword());
        System.out.println("old password: "+bCryptPasswordEncoder.encode(oldPassword));
       // return bCryptPasswordEncoder.matches(oldPassword,salarie.getPassword());
        if(bCryptPasswordEncoder.matches(oldPassword,salarie.getPassword())){
            salarie.setPassword(newPassword);
            updateSalarieById(salarie.getId(),salarie,"Admin");
            return true;
        }
        return false;

    }

}
