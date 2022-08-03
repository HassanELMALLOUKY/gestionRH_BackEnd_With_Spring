package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.B2Paie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface B2PaieRepository extends JpaRepository<B2Paie, Integer> {
        List<B2Paie> findBysalarie_id(Integer salarie);
        }
