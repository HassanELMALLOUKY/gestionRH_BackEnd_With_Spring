package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Attendance;
import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.AbscentRepositories;
import com.YadouSoft.gestionRH.repositories.AttendanceRepositories;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.text.DecimalFormat;
import java.time.Duration;
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
         float res;
        float dif1=DiffBetwenTowDateTime(abscent.getFirst_in(),abscent.getFirst_out());
        float dif2=DiffBetwenTowDateTime(abscent.getLast_in(),abscent.getLast_out());
        // res=dif1+dif2;
        System.out.println(jsondateTotimeHourMunit(abscent.getFirst_out()).getHour());

        if(jsondateTotimeHourMunit(abscent.getFirst_out()).getHour()==00){
            System.out.println(jsondateTotimeHourMunit(abscent.getFirst_out()).getHour());
          res=00;

        }
         else{
             res=dif1;;
            if(jsondateTotimeHourMunit(abscent.getLast_out()).getHour()!=00){
                res+=dif2;
            }

            }



        DecimalFormat df = new DecimalFormat("#.##");

       // System.out.println(df.format(res));
        abscent.setTotal(df.format(res));
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



    //duration betwen tow date

    public float DiffBetwenTowDateTime( String datetime1 , String datetime2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime from = LocalDateTime.parse(datetime1, formatter);
        LocalDateTime to = LocalDateTime.parse(datetime2, formatter);
        Duration duration = Duration.between(from, to);
        float res=(float) duration.toMinutes()/60;
        return res;

    }
    public LocalDateTime  jsondateTotimeHourMunit(String datetime1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime from = LocalDateTime.parse(datetime1, formatter);


       return from;
    }
  /*
  public float getTotal(){



  }*/


}
