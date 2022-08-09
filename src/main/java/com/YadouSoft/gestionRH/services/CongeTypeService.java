package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.CongeType;

import java.util.List;

public interface CongeTypeService {
    CongeType saveCongeType(CongeType congeType);

    List<CongeType> fetchAllCongeType();

    CongeType fetchOneCongeType(Long id);

    CongeType updateCongeType(CongeType congeType, Long id);

    void deleteCongeType(Long id);


}
