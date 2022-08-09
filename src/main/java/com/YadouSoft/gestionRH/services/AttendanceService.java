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
     float sum25;
     float sum50;
     float sum100;
     float nbr_j_absence;
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
           abscent.setSup25(Float.parseFloat(abscent.getNbr_h_par_jour_sup1()));
           abscent.setSup50(Float.parseFloat(abscent.getNbr_h_par_jour_sup2()));
        }else{
           abscent.setSup50(Float.parseFloat(abscent.getNbr_h_par_jour_sup1()));
           abscent.setSup100(Float.parseFloat(abscent.getNbr_h_par_jour_sup2()));

        }
        abscentRepositories.save(abscent);
    }

    public  float getTotal(abscent abscent){
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
        float jjj=Float.parseFloat(df.format(8-res));
        abscent.setNbr_h_absence(Float.parseFloat(df.format(8-res)));
        System.out.println(Float.parseFloat(df.format(8-res)));
        //abscent.setTotal(df.format(res));

        return Float.parseFloat(df.format(8-res));
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


  public List<abscent> getAllbycin(String cin){

        return  abscentRepositories.getByCin(cin);
  }



   // get number day absence by cin
  public  float getSumNbrDayabsence(String cin){
        this.nbr_j_absence=0;
        getAllbycin(cin).forEach(abscent -> {
            nbr_j_absence+=abscent.getNbr_h_absence();
        });
        return nbr_j_absence/24;
    }



    // get number h supp of type 25  by cin
  public  float getSumSup25byCin(String cin){
        this.sum25=0;
        getAllbycin(cin).forEach(abscent -> {
            sum25+=abscent.getSup25();
        });
      return sum25;
  }

    // get number h supp of type 25  by cin
  public  float getSumSup50byCin(String

                                         cin){
        this.sum50=0;
        getAllbycin(cin).forEach(abscent -> {
            sum50+=abscent.getSup50();
        });
        return sum50;
    }

    // get number h supp of type 100  by cin
  public  float getSumSup100byCin(String cin){
        this.sum100=0;
        getAllbycin(cin).forEach(abscent -> {
            sum100+=abscent.getSup50();
        });
        return sum100;
    }

}
