package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Conge;

import java.util.List;

public interface CongeService {
    Conge saveConge(Conge conge);
    List<Conge> fetchAllConge();
    Conge fetchOneConge(Long id);

    Conge updateConge(Conge conge, Long id);
    void deleteConge(Long id);
}
