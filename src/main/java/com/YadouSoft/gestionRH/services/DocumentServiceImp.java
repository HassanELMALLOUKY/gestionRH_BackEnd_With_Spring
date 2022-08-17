package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Document;
import com.YadouSoft.gestionRH.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DocumentServiceImp implements DocumentService{

    @Autowired
    private DocumentRepository documentRepository;


    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public Optional<Document> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Document add(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document update(Long id, Document document) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
