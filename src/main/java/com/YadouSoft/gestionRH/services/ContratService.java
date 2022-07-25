package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratService {
    @Autowired
    ContratRepository contratRepository;
    public Contrat getContratById(long id){
        return contratRepository.findById(id).get();
    }
    public List<Contrat> getAllContrats(){
        return contratRepository.findAll();
    }
}
