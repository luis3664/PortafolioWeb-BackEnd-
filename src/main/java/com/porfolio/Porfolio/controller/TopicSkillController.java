
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Bar;
import com.porfolio.Porfolio.model.TopicSkill;
import com.porfolio.Porfolio.service.IBarService;
import com.porfolio.Porfolio.service.ITopicSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicSkillController {
    
    @Autowired
    ITopicSkillService intTopi;
    
    @Autowired
    IBarService intBar;
    
    @PostMapping ("/topic/add")
    public String saveTopic (@RequestBody TopicSkill topic){
        intTopi.crtTopic(topic);
        return "Topic successfully created in directory.";
    }
    
    @GetMapping ("/topic/{id}")
    @ResponseBody
    public TopicSkill readTopic (@PathVariable Integer id){
        return intTopi.readTopic(id);
    }
    
    @PutMapping ("/topic/{id}/update")
    public String updTopic (@PathVariable Integer id,
                        @RequestBody TopicSkill topic){
        
        TopicSkill topicNew = intTopi.readTopic(id);
        
        topicNew.setTitle(topic.getTitle());
        topicNew.setSecAssigT(topic.getSecAssigT());
        topicNew.setListBar(topic.getListBar());
        
        intTopi.crtTopic(topicNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/topic/delete")
    public String delTopic (@RequestParam Integer id){
        intTopi.delTopic(id);
        return "Topic successfully removed from directory.";
    }
    
    @GetMapping ("/topic/readAll")
    @ResponseBody
    public List<TopicSkill> readAllTopic (){
        return intTopi.ReadAllTopic();
    }
    
    @PutMapping ("/topic/addBar")
    public String addBarT (@RequestParam Integer idTopic,
                           @RequestParam Integer idBar){
        TopicSkill topic = intTopi.readTopic(idTopic);
        Bar bar = intBar.readBar(idBar);

        bar.setTopicAssigned(topic);
        intBar.crtBar(bar);
        
        return "Operation performed satisfactorily.";
    }
    
}
