package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.models.abscent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@CrossOrigin("*")

public interface SalarieRepository extends JpaRepository<Salarie, Long> {

    public Salarie getSalarieByCINE(String cine);
    public Salarie deleteSalarieByCINE(long id);
    @Query("select s.nom from Salarie s")
    public List<String> getSalarieNames();
    public Salarie getSalarieByNomAndPrenom(String nom, String prenom);
    @Query("select s from Salarie s where s.id not in (select d.salarie.id from DocAdminstratifJoindre d)")
    //@Query("select s from DocAdminstratifJoindre d join Salarie s on d.salarie.id = s.id")
    public List<Salarie> getRestSalaries();

}
