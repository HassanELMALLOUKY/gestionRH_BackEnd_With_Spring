package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.DemandeDoc;
import com.YadouSoft.gestionRH.repositories.DemandeDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeDocService {
    @Autowired
    DemandeDocRepository demandeDocRepository;

    public DemandeDoc getDemandeDocById(long id){
        return demandeDocRepository.findById(id).get();
    }

    public List<DemandeDoc> getAllDemandeDocs(){
        return demandeDocRepository.findAll();
    }

    public List<DemandeDoc> findAllByOrderByIdDesc() {
        return demandeDocRepository.findAllByOrderByIdDesc();
    }



    public DemandeDoc saveDemandeDoc(DemandeDoc demandeDoc) {
        return demandeDocRepository.save(demandeDoc);
    }

    public DemandeDoc updateDemandeDoc(DemandeDoc demandeDoc, Long demandeDocId) {
        demandeDoc.setId(demandeDocId);
        return demandeDocRepository.save(demandeDoc);
    }

    public void deleteDemandeDoc(Long demandeDocId) {
        demandeDocRepository.deleteById(demandeDocId);
    }

    public List<DemandeDoc> demandeDocByPersonne(Integer id){
        return demandeDocRepository.demandeDocByPersonne(id);    }

}
