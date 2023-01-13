
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Img;
import com.porfolio.Porfolio.service.IImgService;
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
public class ImgController {
    
    @Autowired
    IImgService intImg;
    
    @PostMapping ("/img/add")
    public String saveImg (@RequestBody Img img){
        intImg.crtImg(img);
        return "IMG successfully created in directory.";
    }
    
    @GetMapping ("/img/{id}")
    @ResponseBody
    public Img readImg (@PathVariable Integer id){
        return intImg.readImg(id);
    }
    
    @PutMapping ("/img/{id}/update")
    public String updImg (@PathVariable Integer id,
                        @RequestParam ("name") String nameNew,
                        @RequestParam ("url") String urlNew){
        
        Img imgNew = intImg.readImg(id);
        
        imgNew.setName(nameNew);
        imgNew.setUrl(urlNew);
        
        intImg.crtImg(imgNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/img/delete")
    public String delImg (@RequestParam Integer id){
        intImg.delImg(id);
        return "Img successfully removed from directory.";
    }
    
    @GetMapping ("/img/readAll")
    @ResponseBody
    public List<Img> readAllImg (){
        return intImg.ReadAllImg();
    }
    
}
