package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.repositories.B2PaieRepository;
import com.YadouSoft.gestionRH.repositories.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class B2PaieService {
  @Autowired
    B2PaieRepository b2PaieRepository;
    SalarieRepository salarieRepository;

    B2Paie b;

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
  public B2Paie updateFicheP(B2Paie b2Paie, Integer id) {
    b2Paie.setId(id);
    return b2PaieRepository.save(b2Paie);
  }
  public List<B2Paie> findByEmployee_Id(Integer salarie_id) {
    return b2PaieRepository.findBysalarie_id(salarie_id);
  }


  public Salarie getsalarieInfo(Integer id){
  return b2PaieRepository.findById(id).get().getSalarie();
    //return  b2PaieRepository.getEmpInfo(salarie);
  }
  public  B2Paie SettingData(Integer id){
    b=new B2Paie();
    return null ;
    //double heureSupp=
    //b.setHeuresSupp();
    //double salaireB=getsalarieInfo(id).getSalaireBase()+b.getIndemniteDedeplacement()+
            //b.getIndemniteDeResponsabilite()+b.getIndemniteDeTransport()+b.getPrimeDebilan()+b.



  }


}

