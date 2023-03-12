
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Bar;
import com.porfolio.Porfolio.model.Icon;
import com.porfolio.Porfolio.service.IBarService;
import com.porfolio.Porfolio.service.IIconService;
import com.porfolio.Porfolio.service.ITopicSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BarController {
    
    @Autowired
    IBarService intBar;
    
    @Autowired
    IIconService intIcon;
    
    @Autowired
    ITopicSkillService intTopi;
    
    @PostMapping ("/bar/add")
    @ResponseBody
    public Integer saveBar (@RequestParam Integer idIcon,
                        @RequestBody Bar bar){
        bar.setIcon(null);
        Bar barNew = intBar.crtBar(bar);
        Icon icon = intIcon.readIcon(idIcon);

        barNew = addIconB(barNew.getId(), icon.getId());

        return barNew.getId();
    }
    
    @GetMapping ("/bar/{id}")
    @ResponseBody
    public Bar readBar (@PathVariable Integer id){
        return intBar.readBar(id);
    }
    
    @PutMapping ("/bar/{id}/update")
    public Bar updBar (@PathVariable Integer id,
                        @RequestParam Integer idIcon,
                        @RequestBody Bar bar){
        
        Bar barNew = intBar.readBar(id);
        
        barNew.setTitle(bar.getTitle());
        barNew.setValue(bar.getValue());
        barNew.setIcon(bar.getIcon());

        return intBar.crtBar(barNew);
    }
    
    @DeleteMapping ("/bar/delete")
    public void delBar (@RequestParam Integer idBar){
        intBar.delBar(idBar);
    }
    
    @GetMapping ("/bar/readAll")
    @ResponseBody
    public List<Bar> readAllBar (){
        return intBar.ReadAllBar();
    }
    
    @PutMapping ("/bar/addIcon")
    public Bar addIconB (@RequestParam Integer idBar,
                            @RequestParam Integer idIcon){
        Bar bar = intBar.readBar(idBar);
        bar.setIcon(intIcon.readIcon(idIcon));

        return intBar.crtBar(bar);
    }
    
}
