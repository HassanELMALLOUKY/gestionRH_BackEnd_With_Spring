package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.DocAdminstratifJoindre;
import com.YadouSoft.gestionRH.repositories.ContratRepository;
import com.YadouSoft.gestionRH.repositories.DocAdministratifJoindreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocAdministratifJoindreService {
    @Autowired
    DocAdministratifJoindreRepository docAdministratifJoindreRepository;
    public DocAdminstratifJoindre getDocById(long id){
        return docAdministratifJoindreRepository.findById(id).get();
    }
    public List<DocAdminstratifJoindre> getAllDocuments(){
        return docAdministratifJoindreRepository.findAll();
    }
}
