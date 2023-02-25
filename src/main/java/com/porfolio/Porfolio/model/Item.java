
package com.porfolio.Porfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String title;
    private String text;
    
    @JsonIgnore
    @ManyToOne
    private Section secAssigI;
    
    @OneToOne
    private Certificate certificate;
    
    @ManyToMany
    private List<Img> imgAssigned;
    
    @ManyToMany
    private List<Icon> iconAssigned;
    
    @OneToOne
    private TextCard textCard;
}
