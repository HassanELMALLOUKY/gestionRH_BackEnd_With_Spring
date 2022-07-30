package com.YadouSoft.gestionRH.repositories;

import com.YadouSoft.gestionRH.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepositories extends JpaRepository<Attendance,Long> {


}
