package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.B2Paie;
import com.YadouSoft.gestionRH.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface B2PaieRepository extends JpaRepository<B2Paie, Long> {
        B2Paie findBysalarie_id(long salarie);

       // @Query("select  b from B2Paie  b join  b.salarie s where b.id=b.salarie.id")
       @Query("select s from B2Paie b join b.salarie s where s.id = b.salarie.id ")
       List<Salarie> getsalByb2();
        }
