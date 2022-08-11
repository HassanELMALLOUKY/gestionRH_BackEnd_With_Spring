package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Conge;
import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.ContratRepository;
import com.YadouSoft.gestionRH.repositories.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SalarieService {
    @Autowired
    SalarieRepository salarieRepository;
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
        return salarieRepository.save(salarie);
    }
    public Collection<Conge> getConge(long id){
        return salarieRepository.findById(id).get().getCongeCollection();
    }
}
