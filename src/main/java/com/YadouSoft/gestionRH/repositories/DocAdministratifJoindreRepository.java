package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.DocAdminstratifJoindre;
import com.YadouSoft.gestionRH.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocAdministratifJoindreRepository extends JpaRepository<DocAdminstratifJoindre, Long> {

}
