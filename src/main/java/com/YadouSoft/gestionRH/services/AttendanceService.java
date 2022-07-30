package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Attendance;
import com.YadouSoft.gestionRH.models.Salarie;
import com.YadouSoft.gestionRH.repositories.AttendanceRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

 private AttendanceRepositories attendanceRepositories;

 //inject the AttendanceRepositories
    public AttendanceService(AttendanceRepositories attendanceRepositories) {
        this.attendanceRepositories = attendanceRepositories; }


//fuction add Attendance
  public  void  addAttendance(Attendance attendance){
        attendanceRepositories.save(attendance);
  }


//function deleteAttendance
  public  void  deleteAttendance(Long id){
     attendanceRepositories.deleteById(id);
 }


//function updateAttendance
  public void updateAttendance(Attendance newAttendance,Long id){
      newAttendance.setId(id);
      attendanceRepositories.save(newAttendance);
    }

//fuction getAttendence
public  Attendance  getAttendance(Long id){
        return attendanceRepositories.getReferenceById(id);
}

//fuction getAttendence
public List<Attendance> getAllAttendance(){
return  attendanceRepositories.findAll();
}



}
