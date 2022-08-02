package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Attendance;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.AbscentRepositories;
import com.YadouSoft.gestionRH.repositories.AttendanceRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class AttendanceService {

 private AttendanceRepositories attendanceRepositories;
    private AbscentRepositories abscentRepositories;
 //inject the AttendanceRepositories
    public AttendanceService(AttendanceRepositories attendanceRepositories, AbscentRepositories abscentRepositories) {
        this.attendanceRepositories = attendanceRepositories;
        this.abscentRepositories = abscentRepositories;
    }


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
    //fuction add Attendance
    public  void  addAbscent(abscent abscent){
       // String chanie=abscent.getFirst_in();
       // System.out.print(chanie);
       // String[] words = chanie.split("T");
        //System.out.println(Arrays.toString(words));
       // LocalDateTime dateTime = LocalDateTime.parse(abscent.getFirst_in());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime newDate = LocalDateTime.parse(abscent.getFirst_in(), formatter);
        System.out.print(newDate.getHour());
        abscentRepositories.save(abscent);
    }


    //fuction getAttendence
    public List<abscent> getAllAbscent(){
        return  abscentRepositories.findAll();
    }
    //fuction getAttendence
    public void deleteAbscent(Long id){
        abscentRepositories.deleteById(id);
    }
}
