package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.DemandeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface DemandeDocRepository extends JpaRepository<DemandeDoc,Long> {
}
