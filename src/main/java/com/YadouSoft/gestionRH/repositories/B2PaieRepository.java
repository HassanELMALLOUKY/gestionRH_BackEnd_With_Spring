package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.B2Paie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface B2PaieRepository extends JpaRepository<B2Paie, Long> {

        }
