package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.abscent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbscentRepositories extends JpaRepository<abscent,Long> {


    List<abscent>   getByCin(String cin);


}
