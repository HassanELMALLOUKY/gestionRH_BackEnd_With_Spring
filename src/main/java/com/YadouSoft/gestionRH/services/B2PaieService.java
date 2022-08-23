package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.AbscentRepositories;
import com.YadouSoft.gestionRH.repositories.B2PaieRepository;
import com.YadouSoft.gestionRH.repositories.SalarieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class B2PaieService {
  @Autowired
    B2PaieRepository b2PaieRepository;
    SalarieRepository salarieRepository;
  AbscentRepositories  abscentRepositories;
  @Autowired
  AttendanceService attendanceService;

    B2Paie b;

  public B2Paie addFicheP(B2Paie fiche_p) {
    return  b2PaieRepository.save(fiche_p);

  }
  public B2Paie getFicheP(long id_fiche) {
    return b2PaieRepository.findById(id_fiche).get();
  }
  public List<B2Paie> getAllFicheP() {
    return b2PaieRepository.findAll();
  }
  public B2Paie deleteFicheP(long id) {
    b2PaieRepository.deleteById(id);

    return null;
  }
  public B2Paie updateFicheP(B2Paie b2Paie, long id) {
    b2Paie.setId(id);
    return b2PaieRepository.save(b2Paie);
  }
  public B2Paie findByEmployee_Id(long salarie_id) {
    return b2PaieRepository.findBysalarie_id(salarie_id);
  }


  public Salarie getsalarieInfo(long id){
  return b2PaieRepository.findById(id).get().getSalarie();
    //return  b2PaieRepository.getEmpInfo(salarie);

  }
    public List<Salarie> getsalByb2(){
        return b2PaieRepository.getsalByb2();
    }

  public  B2Paie SettingData(long id){
    String cine=getsalarieInfo(id).getCINE();
    b=getFicheP(id);
    b.setName(getsalarieInfo(id).getNom());
    Double tauxN=getsalarieInfo(id).getTauxNormal();
    Double hs25=attendanceService.getSumSup25byCin(cine)*(tauxN * 1.25) ;
    Double hs50=attendanceService.getSumSup50byCin(cine) *(tauxN*1.5) ;
    Double hs100=attendanceService.getSumSup100byCin(cine) *(tauxN *2);
    Double heureSupp=hs25+hs50+hs100;

   b.setHeuresSupp(heureSupp);
    Double primeAnciente= Double.valueOf(0);
    Double salB= Double.valueOf(getsalarieInfo(id).getSalaireBase());
    Double anciente=getsalarieInfo(id).getAnciennete();

    if (anciente < 2) {
      primeAnciente = Double.valueOf(0);
    } else if (anciente >= 2 && anciente < 5) {
      primeAnciente = (salB+heureSupp) * 0.05;
    } else if (anciente >= 5 && anciente < 12) {
      primeAnciente = (salB+heureSupp) * 0.1;
    } else if (anciente >= 12 && anciente < 20) {
      primeAnciente = (salB+heureSupp) * 0.15;
    } else if (anciente >= 20 && anciente < 25) {
      primeAnciente = (salB+heureSupp) * 0.2;
    } else if ( anciente >= 25) {
      primeAnciente = (salB+heureSupp) * 0.25;
    }
   b.setPrimeDanciennete(primeAnciente);
    updateFicheP(b,id);
  Double salaireBrG=salB+b.getIndemniteDedeplacement()+
            b.getIndemniteDeResponsabilite()+b.getIndemniteDeTransport()+b.getPrimeDebilan()+
            primeAnciente+b.getPrimeDePanier()+b.getPrimeDerendement()+b.getVoituredefonction()+b.getIndemniteDeLogement();
  b.setSalaireBrut(salaireBrG);
  Double elementsExonorés=b.getIndemniteDedeplacement()+b.getIndemniteDeTransport()+b.getPrimeDePanier()+ b.getVoituredefonction();
  b.setEletexo(elementsExonorés);
   Double brutImposable=salaireBrG-elementsExonorés;
  b.setSalaireBrutImposable(brutImposable);
      updateFicheP(b,id);
    Double cotisationCnss;
    if(brutImposable<=6000){
    cotisationCnss=salaireBrG*0.0448;}
    else {cotisationCnss=6000*0.0448;}
    b.setCNSS(cotisationCnss);
    Double cotisationAmo=brutImposable*0.0226;
    b.setAMO(cotisationAmo);
    Double assurM=brutImposable*0.0259;
    b.setAssuranceM(assurM);
    Double cimr=brutImposable*0.06;
    b.setCimr(cimr);
    Double Frais=(brutImposable-b.getIndemniteDeLogement())*0.2;
    Double cotisationFraisProf;
    if (Frais>2500){
     cotisationFraisProf= Double.valueOf(2500);}else{cotisationFraisProf=Frais;}
    b.setFraisProf(cotisationFraisProf);
    b.setPrestationFamiliale(brutImposable*0.640);
    b.setPrestationSociale(brutImposable*0.898);
    b.setFormatioProf(brutImposable*0.016);
    b.setAmoPatronale(brutImposable*0.411);
    b.setMutuellePatronale(brutImposable*0.0259);

    Double netImposable=brutImposable-cotisationCnss-cotisationAmo-cimr-cotisationFraisProf-assurM;
    b.setNetImposable(netImposable);
    Double irBrut=0.0;
    if(netImposable>2501 && netImposable<4167){
      irBrut=(netImposable*0.1)-250;
    }else if(netImposable>=4167 && netImposable<5001){
        irBrut=(netImposable*0.2)-666.67;
    }else if (netImposable>5001 && netImposable<6667){
       irBrut=(netImposable*0.3)-1166.67;
    } else if (netImposable>=6667 && netImposable<15000) {
        irBrut=(netImposable*0.34)-1433.33;
    } else if (netImposable>=15000) {
        irBrut=(netImposable*0.38)-2033.33;
    }
     b.setIrBrut(irBrut);
    boolean situationF=getsalarieInfo(id).getMarie();
    Integer nbrEnf=getsalarieInfo(id).getNombreEnfants();
    Integer chargeFam=0;
    if (situationF==false ){
        chargeFam=0;
    }
    else if(situationF==true && nbrEnf==0 ){
              chargeFam=30;
    } else if (situationF==true && nbrEnf>5){chargeFam=180;}
    else if (situationF==true && nbrEnf>0) {
    chargeFam=30*nbrEnf+30;
    }
    b.setChargeFamille(chargeFam);
   Double IrNet;
    if (irBrut>chargeFam){
        IrNet=irBrut-chargeFam;
    }else {IrNet=0.0;}
      b.setIR(IrNet);
    Double netApayer=salaireBrG-IrNet-cotisationCnss-cotisationAmo-cimr-assurM;
    b.setSalaireNet(netApayer);
      updateFicheP(b,id);
    return b;

  }


}

