package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Modification;
import com.YadouSoft.gestionRH.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModificationRepository extends JpaRepository<Modification,Long> {
}
