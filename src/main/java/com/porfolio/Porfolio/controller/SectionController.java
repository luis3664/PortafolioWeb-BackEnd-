
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Section;
import com.porfolio.Porfolio.service.ISectionService;
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
public class SectionController {
    
    @Autowired
    ISectionService intSec;
    
    @PostMapping ("/sec/add")
    public String saveImg (@RequestBody Section sec){
        intSec.crtSection(sec);
        return "Section successfully created in directory.";
    }
    
    @GetMapping ("/sec/{id}")
    @ResponseBody
    public Section readSec (@PathVariable Integer id){
        return intSec.readSection(id);
    }
    
    @PutMapping ("/sec/{id}/update")
    public String updImg (@PathVariable Integer id,
                        @RequestParam ("title") String titleNew,
                        @RequestParam ("imgUrl") String imgNew){
        
        Section secNew = intSec.readSection(id);
        
        secNew.setTitle(titleNew);
        secNew.setImgUrl(imgNew);
        
        intSec.crtSection(secNew);
        
        return "Updating successfully.";
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
    
}
