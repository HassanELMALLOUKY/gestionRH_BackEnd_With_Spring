package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Conge;
import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.ContratRepository;
import com.YadouSoft.gestionRH.repositories.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

@Service
@CrossOrigin("*")
public class SalarieService {
    SalarieRepository salarieRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public SalarieService(SalarieRepository salarieRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.salarieRepository = salarieRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PreAuthorize("hasAnyAuthority('Admin','Basic','Documenteur','Paie','Superviseur')")
    public Salarie getSalarieById(long id){

        return salarieRepository.findById(id).get();
    }
    public Salarie getSalarieByCINE(String cine){

        return salarieRepository.getSalarieByCINE(cine);
    }
    /*public Salarie getSalarieByCINE(String cine){

        return salarieRepository.getSalarieByCINE(cine);
    }*/

    public List<Salarie> deleteSalarieById(long id){
        salarieRepository.deleteById(id);
        return salarieRepository.findAll();
    }

    public List<Salarie> getAllSalaries(){

        return salarieRepository.findAll();
    }
    public List<String> getAllSalariesNames(){
        return salarieRepository.getSalarieNames();
    }
    public Salarie addSalarie(Salarie salarie){

        salarie.setPassword(bCryptPasswordEncoder.encode(salarie.getPassword()));
        return salarieRepository.save(salarie);
    }
    public Collection<Conge> getConge(long id){
        return salarieRepository.findById(id).get().getCongeCollection();
    }
    public Salarie getSalarieByNomAndPrenom(String nom, String prenom){
        return salarieRepository.getSalarieByNomAndPrenom(nom, prenom);
    }
    public List<Salarie> getRestSalaries(){
        return salarieRepository.getRestSalaries();
    }

    public Salarie loadUserByUsername(String username) {
        return salarieRepository.getSalarieByUsername(username);
    }

}
