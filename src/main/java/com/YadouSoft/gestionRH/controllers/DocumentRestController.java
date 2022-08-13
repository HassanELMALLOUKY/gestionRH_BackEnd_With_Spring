package com.YadouSoft.gestionRH.controllers;

import com.YadouSoft.gestionRH.models.Document;
import com.YadouSoft.gestionRH.repositories.DocumentRepository;

import com.YadouSoft.gestionRH.services.DocumentService;
import com.YadouSoft.gestionRH.services.DocumentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/document")
@CrossOrigin(origins ="*")
@RestController
public class DocumentRestController {
    @Autowired
    private DocumentRepository documentRepository;

    @PostMapping("/add")
    public Document add(@RequestBody Document document){
        return this.documentRepository.save(document);

    }

    @GetMapping ("/all")
    public List<Document> getAll(){
        return documentRepository.findAll();

    }
    @PutMapping
    public Document update(@PathVariable(name = "id") Long id,@RequestBody Document document){
        document.setId(id);
        return documentRepository.save(document);
    }

    @DeleteMapping
    public void delete(Long id){
        documentRepository.deleteById(id);
    }

}
