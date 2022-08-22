package com.YadouSoft.gestionRH;



import com.YadouSoft.gestionRH.services.SalarieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionRhApplication{
    public static void main(String[] args) {


        SpringApplication.run(GestionRhApplication.class, args);
    }



    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }


}
