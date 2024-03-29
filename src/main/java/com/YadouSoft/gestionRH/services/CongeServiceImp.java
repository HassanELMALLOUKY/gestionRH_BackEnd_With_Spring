package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.beens.CongeInfo;
import com.YadouSoft.gestionRH.enums.Statut;
import com.YadouSoft.gestionRH.models.Conge;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.repositories.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CongeServiceImp implements CongeService{
    @Autowired
    private CongeRepository congeRepository;
    @Autowired
    private AttendanceService attendanceService;

    @Override
    public Conge saveConge(Conge conge) {
        conge.setSold(String.valueOf((conge.getSalarie().getAnciennete())));
        System.out.println("Sold Value ::::::::"+ (conge.getSalarie().getAnciennete()));
        conge.setNoOfDays(String.valueOf(attendanceService.getSumNbrDayabsence(String.valueOf(conge.getSalarie().getId()))));
        System.out.println("Absent days value :::::::::::"+ attendanceService.getSumNbrDayabsence(String.valueOf(conge.getSalarie().getId())));
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


    @Override
    public List<Conge> CongesByPersonne(String CIN) {
        return congeRepository.CongesByPersonne(CIN);
    }

    @Override
    public List<CongeInfo> getAllCongeInfo() {
        List<CongeInfo> congeInfos = new ArrayList<>();
        List<Object[]> result = congeRepository.getAllCongeInfo();
        for (Object o[] : result){
            CongeInfo congeInfo = new CongeInfo();
            Conge conge = (Conge) o[0];
            Salarie salarie = (Salarie) o[1];
            congeInfo.setSalarieName(salarie.getNom());
            congeInfo.setDate_debut(conge.getFrom().toString());
            congeInfo.setDate_fin(conge.getLeaveTo().toString());
            congeInfo.setMotif(conge.getReason());
            congeInfo.setStatus(conge.getStatus().toString());
            congeInfo.setDemi_journee(conge.getNoOfDays());
            congeInfo.setType(conge.getType().getType());

            congeInfos.add(congeInfo);
        }
        return congeInfos;
    }

    @Override
    public List<Conge> getCongesByStatus(Statut status) {
        return congeRepository.getCongesByStatus(status);
    }


}
