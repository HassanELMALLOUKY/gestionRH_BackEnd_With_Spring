package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.DemandeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface DemandeDocRepository extends JpaRepository<DemandeDoc,Long> {
}
