package com.YadouSoft.gestionRH;



import com.YadouSoft.gestionRH.models.Document;
import com.YadouSoft.gestionRH.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionRhApplication implements CommandLineRunner {
    @Autowired
    private  DocumentRepository documentRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionRhApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        documentRepository.save(new Document(1,"Attestation de de travaille","<p><span style=\"color: rgb(0, 71, 178);\">Yadou Soft</span></p><p><br></p><p><br></p><p><br></p><p>&nbsp;&nbsp;&nbsp;\t\tObjet : Attestation de de travaille.</p><p><br></p><p>\tJe soussigne&nbsp;M. <strong>{nomEmployee}</strong> , agissant en qualite de <strong>{employeFonction} </strong>de Yadou soft,et demeurant <strong>{employeAdress}</strong>,est embauche dans notre societe depuis le <strong>{employeDateEmbauche}</strong></p><p><br></p>"));
    }
}
