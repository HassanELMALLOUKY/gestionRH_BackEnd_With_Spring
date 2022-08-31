package com.YadouSoft.gestionRH;



import com.YadouSoft.gestionRH.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionRhApplication  {
    @Autowired
    private DocumentRepository documentRepository;
    public static void main(String[] args) {


        SpringApplication.run(GestionRhApplication.class, args);
    }



    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }



}
