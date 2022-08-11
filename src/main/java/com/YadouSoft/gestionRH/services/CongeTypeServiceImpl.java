package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.CongeType;
import com.YadouSoft.gestionRH.repositories.CongeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeTypeServiceImpl implements CongeTypeService {
    @Autowired
    private CongeTypeRepository congeTypeRepository;

    @Override
    public CongeType saveCongeType(CongeType congeType) {
        return congeTypeRepository.save(congeType);
    }

    @Override
    public List<CongeType> fetchAllCongeType() {
        return congeTypeRepository.findAll();
    }

    @Override
    public CongeType fetchOneCongeType(Long id) {
        return congeTypeRepository.findById(id).get();
    }

    @Override
    public CongeType updateCongeType(CongeType congeType, Long id) {
        congeType.setId(id);
        return congeTypeRepository.save(congeType);
    }

    @Override
    public void deleteCongeType(Long id) {
        congeTypeRepository.deleteById(id);
    }
}
