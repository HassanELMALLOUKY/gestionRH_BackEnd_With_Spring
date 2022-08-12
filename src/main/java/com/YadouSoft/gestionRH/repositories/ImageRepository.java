package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Image;
import com.YadouSoft.gestionRH.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
@CrossOrigin("*")

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findImageByName(String name);


}
