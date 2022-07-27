package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Contrat;
import com.YadouSoft.gestionRH.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Long> {
    public Salarie getSalarieByCINE(String cine);
    public Salarie deleteSalarieByCINE(String cine);
}
