package com.YadouSoft.gestionRH.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Document implements Serializable {
    @Id @GeneratedValue
    private long id;
    private String name;
    @Lob //Lob annotation is used for long text area
    private String documentCodeHtml;

}
