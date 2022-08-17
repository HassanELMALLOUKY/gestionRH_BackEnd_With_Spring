package com.YadouSoft.gestionRH.services;

import com.YadouSoft.gestionRH.models.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public interface DocumentService {
     List<Document> getAll();
     Optional<Document> getById(@PathVariable(name = "id") Long id);
     Document add(Document document);
     Document update(@PathVariable(name = "id") Long id,@RequestBody Document document);
     void delete(Long id);
}
