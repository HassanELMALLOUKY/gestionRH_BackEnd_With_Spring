package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {
    @Override
    void deleteById(Long aLong);
}
