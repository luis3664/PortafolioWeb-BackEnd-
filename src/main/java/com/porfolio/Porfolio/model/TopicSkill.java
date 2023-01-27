
package com.porfolio.Porfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
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
    
    @JsonIgnore
    @ManyToOne
    private Section secAssigT;
    
    @OneToMany (mappedBy="topicAssigned")
    private List<Bar> listBar = new ArrayList<>();
    
    // Constructors
    public TopicSkill(){
    }
    public TopicSkill(Integer id, String title, Section secAssigT, List<Bar> listBar) {
        this.id = id;
        this.title = title;
        this.secAssigT = secAssigT;
        this.listBar = listBar;
    }

}
