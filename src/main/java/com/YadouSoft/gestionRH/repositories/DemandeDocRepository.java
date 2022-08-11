package com.YadouSoft.gestionRH.repositories;


import com.YadouSoft.gestionRH.models.DemandeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface DemandeDocRepository extends JpaRepository<DemandeDoc,Long> {
    public List<DemandeDoc> findAllByOrderByIdDesc();
    @Query("select c from DemandeDoc c where c.salarie.id=:id")
    public List<DemandeDoc> demandeDocByPersonne(@Param("id")long id);
}
