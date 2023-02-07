
package com.porfolio.Porfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private Integer value;
    
    @JsonIgnore
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn (name="topic_assigned_id")
    private TopicSkill topicAssigned;
    
    @OneToOne
    private Icon icon;

    
    // Constructors
    public Bar(){
    }
    public Bar(Integer id, String title, Integer value, TopicSkill topicAssigned, Icon icon) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.topicAssigned = topicAssigned;
        this.icon = icon;
    }
    
}
