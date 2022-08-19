package com.YadouSoft.gestionRH.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Document implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String Nom;
    @Lob //Lob annotation is used for long text area
    private String documentCodeHtml;
    @Lob //Lob annotation is used for long text area
    private String signatureImg;
    private String CreePar;
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "requestType", cascade = CascadeType.ALL)
    private Collection<DemandeDoc> demandeDocs;

}
