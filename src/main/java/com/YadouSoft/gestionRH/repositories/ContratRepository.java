package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
