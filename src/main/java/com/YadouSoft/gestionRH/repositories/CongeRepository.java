package com.YadouSoft.gestionRH.repositories;


import com.YadouSoft.gestionRH.enums.Statut;
import com.YadouSoft.gestionRH.models.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {

    @Query("select c from Conge c where c.salarie.CINE=:x")
    public List<Conge> CongesByPersonne(@Param("x")String CIN);

    @Query("select c,s from Conge c join c.salarie s where s.CINE = c.salarie.CINE ")
    List<Object[]> getAllCongeInfo();

    List<Conge> getCongesByStatus(Statut status);
}
