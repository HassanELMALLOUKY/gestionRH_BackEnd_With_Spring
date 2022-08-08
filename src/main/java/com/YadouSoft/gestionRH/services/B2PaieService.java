package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.repositories.B2PaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class B2PaieService {
  @Autowired
    B2PaieRepository b2PaieRepository;
  public B2Paie addFicheP(B2Paie fiche_p) {
    return  b2PaieRepository.save(fiche_p);

  }
  public B2Paie getFicheP(Integer id_fiche) {
    return b2PaieRepository.findById(id_fiche).get();
  }
  public List<B2Paie> getAllFicheP() {
    return b2PaieRepository.findAll();
  }
  public B2Paie deleteFicheP(Integer id) {
    b2PaieRepository.deleteById(id);

    return null;
  }
  public List<B2Paie> findByEmployee_Id(Integer salarie_id) {
    return b2PaieRepository.findBysalarie_id(salarie_id);
  }

}
