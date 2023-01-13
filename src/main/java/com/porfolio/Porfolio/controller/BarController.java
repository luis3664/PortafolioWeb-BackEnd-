
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Bar;
import com.porfolio.Porfolio.model.Icon;
import com.porfolio.Porfolio.service.IBarService;
import com.porfolio.Porfolio.service.IIconService;
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
    
    @PostMapping ("/bar/add")
    public String saveImg (@RequestBody Bar bar){
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
                        @RequestParam ("title") String title,
                        @RequestParam ("svgBoolean") Boolean svgBoolean,
                        @RequestParam ("value") Integer value,
                        @RequestParam ("icon") Integer icon){
        
        Bar barNew = intBar.readBar(id);
        Icon iconNew = intIcon.readIcon(icon);
        
        barNew.setTitle(title);
        barNew.setSvgBoolean(svgBoolean);
        barNew.setValue(value);
        barNew.setIcon(iconNew);
        
        intBar.crtBar(barNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/bar/delete")
    public String delBar (@RequestParam Integer id){
        intBar.delBar(id);
        return "Bar successfully removed from directory.";
    }
    
    @GetMapping ("/Bar/readAll")
    @ResponseBody
    public List<Bar> readAllBar (){
        return intBar.ReadAllBar();
    }
    
}
