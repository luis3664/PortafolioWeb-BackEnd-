
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Icon;
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
public class IconController {
    
    @Autowired
    IIconService intIcon;
    
    @PostMapping ("/icon/add")
    public String saveIcon (@RequestBody Icon icon){
        intIcon.crtIcon(icon);
        return "ICON successfully created in directory.";
    }
    
    @GetMapping ("/icon/{id}")
    @ResponseBody
    public Icon readIcon (@PathVariable Integer id){
        return intIcon.readIcon(id);
    }
    
    @PutMapping ("/icon/{id}/update")
    public String updIcon (@PathVariable Integer id,
                        @RequestParam ("name") String nameNew,
                        @RequestParam ("identity") String ideNew){
        
        Icon iconNew = intIcon.readIcon(id);
        
        iconNew.setName(nameNew);
        iconNew.setIdentity(ideNew);
        
        intIcon.crtIcon(iconNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/icon/delete")
    public String delIcon (@RequestParam Integer id){
        intIcon.delIcon(id);
        return "Icon successfully removed from directory.";
    }
    
    @GetMapping ("/icon/readAll")
    @ResponseBody
    public List<Icon> readAllIcon (){
        return intIcon.ReadAllIcon();
    }
    
}
