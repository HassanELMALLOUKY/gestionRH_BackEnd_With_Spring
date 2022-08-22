package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.CongeType;
import com.YadouSoft.gestionRH.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
