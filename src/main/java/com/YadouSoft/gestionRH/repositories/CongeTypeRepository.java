package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.CongeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeTypeRepository extends JpaRepository<CongeType,Long> {
}
