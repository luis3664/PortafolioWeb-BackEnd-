
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Bar;
import com.porfolio.Porfolio.model.Section;
import com.porfolio.Porfolio.model.TopicSkill;
import com.porfolio.Porfolio.service.IBarService;
import com.porfolio.Porfolio.service.ISectionService;
import com.porfolio.Porfolio.service.ITopicSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class TopicSkillController {
    
    @Autowired
    ITopicSkillService intTopi;
    
    @Autowired
    IBarService intBar;

    @Autowired
    ISectionService intSec;
    
    @PostMapping ("/topic/add")
    public TopicSkill saveTopic (@RequestBody TopicSkill topic){
        TopicSkill topicNew = intTopi.crtTopic(topic);

        Section sec = intSec.readSection(4);

        topicNew.setSecAssigT(sec);

        return intTopi.crtTopic(topicNew);
    }
    
    @GetMapping ("/topic/{id}")
    @ResponseBody
    public TopicSkill readTopic (@PathVariable Integer id){
        return intTopi.readTopic(id);
    }
    
    @PutMapping ("/topic/{id}/update")
    public TopicSkill updTopic (@PathVariable Integer id,
                                @RequestBody TopicSkill topic){
        
        TopicSkill topicNew = intTopi.readTopic(id);
        
        topicNew.setTitle(topic.getTitle());
        
        return intTopi.crtTopic(topicNew);
    }
    
    @DeleteMapping ("/topic/delete")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void delTopic (@RequestParam Integer id){
        TopicSkill topic = readTopic(id);

        for (int i = 0; i < topic.getListBar().size(); i++) {
            intBar.delBar(topic.getListBar().get(i).getId());
        }
        topic.setListBar(null);
        intTopi.crtTopic(topic);
        intTopi.delTopic(id);
    }
    
    @GetMapping ("/topic/readAll")
    @ResponseBody
    public List<TopicSkill> readAllTopic (){
        return intTopi.ReadAllTopic();
    }
    
    @PutMapping ("/topic/addBar")
    public Bar addBarT (@RequestParam Integer idTopic,
                           @RequestParam Integer idBar){
        TopicSkill topic = intTopi.readTopic(idTopic);
        Bar bar = intBar.readBar(idBar);

        bar.setTopicAssigned(topic);
        return intBar.crtBar(bar);
    }
    
}
