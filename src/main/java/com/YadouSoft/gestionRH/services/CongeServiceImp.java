package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Conge;
import com.YadouSoft.gestionRH.repositories.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CongeServiceImp implements CongeService{
    @Autowired
    private CongeRepository congeRepository;

    @Override
    public Conge saveConge(Conge conge) {
        return congeRepository.save(conge);
    }

    @Override
    public List<Conge> fetchAllConge() {
        return congeRepository.findAll();
    }

    @Override
    public Conge fetchOneConge(Long id) {
        return congeRepository.findById(id).get();
    }

    @Override
    public Conge updateConge(Conge conge, Long id) {
        conge.setId(id);
        return congeRepository.save(conge);
    }

    @Override
    public void deleteConge(Long id) {
        congeRepository.deleteById(id);
    }
}
