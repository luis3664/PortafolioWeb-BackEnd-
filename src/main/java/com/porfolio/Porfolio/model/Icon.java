
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Icon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String name;
    private String identity;
    private String url;
    private Boolean svg;
    
    // Constructors
    public Icon(){
    }
    public Icon(Integer id, String name, String identity, String url, Boolean svg) {
        this.id = id;
        this.name = name;
        this.identity = identity;
        this.url = url;
        this.svg = svg;
    }
    
}
