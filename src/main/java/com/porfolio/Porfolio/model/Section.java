
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Section {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String title;
    private String imgUrl;
    
    @OneToMany (mappedBy="secAssigT")
    private List<TopicSkill> listTopic;
    
    @OneToMany (mappedBy="secAssigI")
    private List<Item> listItem;
    
    // Constructor
    public Section(Integer id, String title, String imgUrl, List<TopicSkill> listTopic, List<Item> listItem) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.listTopic = listTopic;
        this.listItem = listItem;
    }
    
}
