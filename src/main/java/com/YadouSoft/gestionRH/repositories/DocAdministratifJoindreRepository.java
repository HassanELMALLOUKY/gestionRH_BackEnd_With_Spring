package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.DocAdminstratifJoindre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface DocAdministratifJoindreRepository extends JpaRepository<DocAdminstratifJoindre, Long> {
}
