package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Modification;
import com.YadouSoft.gestionRH.repositories.ModificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModificationService {
    private ModificationRepository modificationRepository;

    public ModificationService(ModificationRepository modificationRepository) {
        this.modificationRepository = modificationRepository;
    }
    public void saveModification(Modification modification) {
        modificationRepository.save(modification);
    }
    public List<Modification> getModifications() {
        return modificationRepository.findAll();
    }
}
