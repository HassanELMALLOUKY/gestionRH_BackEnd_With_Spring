package com.YadouSoft.gestionRH.repositories;


import com.YadouSoft.gestionRH.models.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {
    @Query("select c from Conge c where c.status='Pending'")
    List<Conge> getCongeByStatus();
}
