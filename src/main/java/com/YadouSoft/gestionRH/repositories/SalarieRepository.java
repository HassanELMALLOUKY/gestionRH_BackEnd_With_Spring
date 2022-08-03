package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@RepositoryRestResource
@CrossOrigin("*")

public interface SalarieRepository extends JpaRepository<Salarie, Long> {

    public Salarie getSalarieByCINE( @PathVariable String cine);
    public Salarie deleteSalarieByCINE(String cine);
}
