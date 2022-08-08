package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.beens.CongeInfo;
import com.YadouSoft.gestionRH.enums.Statut;
import com.YadouSoft.gestionRH.models.Conge;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CongeService {
    Conge saveConge(Conge conge);
    List<Conge> fetchAllConge();
    Conge fetchOneConge(Long id);

    Conge updateConge(Conge conge, Long id);
    void deleteConge(Long id);


    List<Conge> CongesByPersonne(String CIN);

    List<CongeInfo> getAllCongeInfo();

    List<Conge> getCongesByStatus(Statut Status);

}
