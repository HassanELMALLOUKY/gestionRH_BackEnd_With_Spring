package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.abscent;
import com.YadouSoft.gestionRH.repositories.AbscentRepositories;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AttendanceService {

    private AbscentRepositories abscentRepositories;

    public AttendanceService(AbscentRepositories abscentRepositories) {
        this.abscentRepositories = abscentRepositories;
    }
    //inject the AttendanceRepositories



//function deleteAttendance

    public  void  addAbscent(abscent abscent){

        abscent.setTotal(getTotal(abscent));
        abscent.setNbr_h_par_jour_sup1(getSup(abscent.getSup1_in(), abscent.getSup1_out()));
        abscent.setNbr_h_par_jour_sup2(getSup(abscent.getSup2_in(),abscent.getSup2_out()));
        if(abscent.getType().equals("normal")){
           //abscent.set
        }else{


        }
        abscentRepositories.save(abscent);
    }

    public  String getTotal(abscent abscent){
        float res;
        float dif1=diffbetwenTime(abscent.getFirst_in(),abscent.getFirst_out());
        float dif2=diffbetwenTime(abscent.getLast_in(),abscent.getLast_out());
        //supp time

        System.out.println(dif1+"  : "+dif2);

        res=dif1+dif2;

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
        System.out.println(df.format(res));
        abscent.setTotal(df.format(res));
        return df.format(res);
    }
    public  String getSup(String supin,String supout){
        float res;
        float dif1=diffbetwenTime(supin,supout);
        if(jsondateTotimeHourMunit(supin).getHour()==00&&jsondateTotimeHourMunit(supout).getHour()==00){
            res=00;

        }else
            res=dif1;


        DecimalFormat df = new DecimalFormat("#.##");

        return df.format(res);
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
        LocalDateTime from = LocalDateTime.parse(jsondateTotimeHouradd(datetime1), formatter);
        LocalDateTime to = LocalDateTime.parse(jsondateTotimeHouradd(datetime2), formatter);
        Duration duration = Duration.between(from, to);
        float res=(float) duration.toMinutes()/60;
        return diffbetwenTime(datetime1,datetime2);

    }
    public LocalDateTime  jsondateTotimeHourMunit(String datetime1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime from = LocalDateTime.parse(datetime1, formatter);


       return from;
    }
    public String         jsondateTotimeHouradd(String datetime1){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        LocalDateTime from = LocalDateTime.parse(datetime1, formatter);
        String date=from.getYear()+"-"+from.getMonth()+"-"+from.getYear()+"'T'"+from.getHour()+":"+from.getMinute()+":"+from.getSecond()+".000Z";
        return date;
    }
    public float          diffbetwenTime(String datetime1 , String datetime2){
        float h1,h2,m1,m2,m,res;
        h1=jsondateTotimeHourMunit(datetime1).getHour();
        h2=jsondateTotimeHourMunit(datetime2).getHour();
        m1=jsondateTotimeHourMunit(datetime1).getMinute();
        m2=jsondateTotimeHourMunit(datetime2).getMinute();
        System.out.println("h1-"+h1+"h2-"+h2+"m1-"+m1+"m2-"+m2);
        if(h2>=h1){
            res=h2-h1;
         System.out.println("h2-h1"+res);
                m=(m2-m1);
                System.out.println("m2-m1- "+m);
                DecimalFormat df = new DecimalFormat("#.##");
                res+=Float.parseFloat(df.format(m/60));
                System.out.println("m- "+Float.parseFloat(df.format(m/60)));
                System.out.println("res-"+res);

        }else res=0;
        return  res;
    }




}
