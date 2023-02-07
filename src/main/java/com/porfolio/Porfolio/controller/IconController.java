
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Icon;
import com.porfolio.Porfolio.service.IIconService;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class IconController {
    
    @Autowired
    IIconService intIcon;
    
    @PostMapping ("/icon/add")
    @ResponseBody
    public Integer saveIcon (@RequestBody Icon icon){
        intIcon.crtIcon(icon);
        int index = intIcon.ReadAllIcon().size() -1;
        List<Icon> list = intIcon.ReadAllIcon();
        
        return list.get(index).getId();
    }
    
    @GetMapping ("/icon/{id}")
    @ResponseBody
    public Icon readIcon (@PathVariable Integer id){
        return intIcon.readIcon(id);
    }
    
    @PutMapping ("/icon/update")
    public String updIcon (@RequestBody Icon icon){
        
        Icon iconNew = intIcon.readIcon(icon.getId());
        
        iconNew.setName(icon.getName());
        iconNew.setIdentity(icon.getIdentity());
        iconNew.setSvg(icon.getSvg());
        iconNew.setUrl(icon.getUrl());
        
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
