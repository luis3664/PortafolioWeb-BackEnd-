
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class TopicSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String title;
    
    @ManyToOne
    private Section secAssigT;
    
    @OneToMany (mappedBy="topicAssigned")
    private List<Bar> listBar;
    
    // Constructor
    public TopicSkill(Integer id, String title, Section secAssigT, List<Bar> listBar) {
        this.id = id;
        this.title = title;
        this.secAssigT = secAssigT;
        this.listBar = listBar;
    }

}
