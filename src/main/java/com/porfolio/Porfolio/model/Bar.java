
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Bar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String title;
    private Boolean svgBoolean;
    private Integer value;
    
    @ManyToOne
    private TopicSkill topicAssigned;
    
    @OneToOne
    private Icon icon;
    
    // Constructor
    public Bar(Integer id, String title, Boolean svgBoolean, Integer value) {
        this.id = id;
        this.title = title;
        this.svgBoolean = svgBoolean;
        this.value = value;
    }
    
}
