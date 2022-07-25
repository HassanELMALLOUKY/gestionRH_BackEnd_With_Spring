package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
