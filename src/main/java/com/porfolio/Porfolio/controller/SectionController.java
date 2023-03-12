
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Item;
import com.porfolio.Porfolio.model.Section;
import com.porfolio.Porfolio.model.TopicSkill;
import com.porfolio.Porfolio.service.IItemService;
import com.porfolio.Porfolio.service.ISectionService;
import com.porfolio.Porfolio.service.ITopicSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class SectionController {
    
    @Autowired
    ISectionService intSec;
    
    @Autowired
    ITopicSkillService intTopi;
    
    @Autowired
    IItemService intItem;
    
    @PostMapping ("/sec/add")
    public String saveSec (@RequestBody Section sec){
        intSec.crtSection(sec);
        return "Section successfully created in directory.";
    }
    
    @GetMapping ("/sec/{id}")
    @ResponseBody
    public Section readSec (@PathVariable Integer id){
        return intSec.readSection(id);
    }
    
    @PutMapping ("/sec/update")
    public void updSec (@RequestBody Section sec){
        
        Section secNew = intSec.readSection(sec.getId());
        
        secNew.setTitle(sec.getTitle());
        
        intSec.crtSection(secNew);
        
//        return "Operation performed satisfactorily.";
    }
    
    @DeleteMapping ("/sec/delete")
    public String delSec (@RequestParam Integer id){
        intSec.delSection(id);
        return "Section successfully removed from directory.";
    }
    
    @GetMapping ("/sec/readAll")
    @ResponseBody
    public List<Section> readAllSec (){
        return intSec.ReadAllSection();
    }
    
    @PutMapping ("/sec/addTopic")
    public String addTopicS (@RequestParam Integer idSec,
                            @RequestParam Integer idTopic){
        List<TopicSkill> listTopic = intSec.readSection(idSec).getListTopic();
        TopicSkill topic = intTopi.readTopic(idTopic);
        Section sec = intSec.readSection(idSec);
        
        listTopic.add(topic);
        sec.setListTopic(listTopic);
        intSec.crtSection(sec);
        
        topic.setSecAssigT(sec);
        intTopi.crtTopic(topic);
        
        return "Operation performed satisfactorily.";
    }
    
    @PutMapping ("/sec/{idSec}/addItem")
    public Item addItemS (@PathVariable Integer idSec,
                            @RequestParam Integer idItem){
        List<Item> listItem = intSec.readSection(idSec).getListItem();
        Item item = intItem.readItem(idItem);
        Section sec = intSec.readSection(idSec);
        
        listItem.add(item);
        sec.setListItem(listItem);
        intSec.crtSection(sec);
        
        item.setSecAssigI(sec);
        intItem.crtItem(item);
        
        return intItem.crtItem(item);
    }
    
}
