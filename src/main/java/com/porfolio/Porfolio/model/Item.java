
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String title;
    private String text;
    
    @ManyToOne
    private Section secAssigI;
    
    @OneToOne
    private Certificate certificate;
    
    @ManyToMany
    private List<Img> imgAssigned;
    
    @ManyToMany
    private List<Icon> iconAssigned;
    
    
    // Constructor
    public Item(Integer id, String title, String text, Section secAssigI, Certificate certificate, List<Img> imgAssigned, List<Icon> iconAssigned) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.secAssigI = secAssigI;
        this.certificate = certificate;
        this.imgAssigned = imgAssigned;
        this.iconAssigned = iconAssigned;
    }

}
