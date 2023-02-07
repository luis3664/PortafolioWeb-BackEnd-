
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Bar;
import com.porfolio.Porfolio.service.IBarService;
import com.porfolio.Porfolio.service.IIconService;
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
public class BarController {
    
    @Autowired
    IBarService intBar;
    
    @Autowired
    IIconService intIcon;
    
    @Autowired
    ITopicSkillService intTopi;
    
    @PostMapping ("/bar/add")
    public String saveBar (@RequestBody Bar bar){
        intBar.crtBar(bar);
        return "Bar successfully created in directory.";
    }
    
    @GetMapping ("/bar/{id}")
    @ResponseBody
    public Bar readBar (@PathVariable Integer id){
        return intBar.readBar(id);
    }
    
    @PutMapping ("/bar/{id}/update")
    public String updBar (@PathVariable Integer id,
                        @RequestBody Bar bar){
        
        Bar barNew = intBar.readBar(id);
        
        barNew.setTitle(bar.getTitle());
        barNew.setValue(bar.getValue());
        barNew.setIcon(bar.getIcon());
        barNew.setTopicAssigned(bar.getTopicAssigned());
        
        intBar.crtBar(barNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/bar/delete")
    public String delBar (@RequestParam Integer id){
        intBar.delBar(id);
        return "Bar successfully removed from directory.";
    }
    
    @GetMapping ("/bar/readAll")
    @ResponseBody
    public List<Bar> readAllBar (){
        return intBar.ReadAllBar();
    }
    
    @PutMapping ("/bar/addIcon")
    public String addIconB (@RequestParam Integer idBar,
                            @RequestParam Integer idIcon){
        Bar bar = intBar.readBar(idBar);
        bar.setIcon(intIcon.readIcon(idIcon));
        
        intBar.crtBar(bar);
        return "Operation performed satisfactorily.";
    }
    
}
