
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Section {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String title;
    
    @OneToMany (mappedBy="secAssigT")
    private List<TopicSkill> listTopic;
    
    @OneToMany (mappedBy="secAssigI")
    private List<Item> listItem;

//    @OneToMany (mappedBy = "secAssigC")
//    private List<CardPresentation> listCardP
    
}
