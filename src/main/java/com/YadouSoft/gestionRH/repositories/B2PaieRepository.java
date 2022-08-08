package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B2PaieRepository extends JpaRepository<B2Paie, Integer> {
        List<B2Paie> findBysalarie_id(Integer salarie);

       // @Query("select  b from B2Paie  b join  b.salarie s where b.id=b.salarie.id")

        }
