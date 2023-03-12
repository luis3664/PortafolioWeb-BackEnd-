
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Img;
import com.porfolio.Porfolio.service.IImgService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImgController {
    
    @Autowired
    IImgService intImg;
    
    @PostMapping ("/img/add")
    public Img saveImg (@RequestBody Img img){
        List<Img> listImg = intImg.findByUrl(img.getUrl());

        if(listImg.size() > 0){
            return listImg.get(0);
        }else {
            return intImg.crtImg(img);
        }
    }
    
    @GetMapping ("/img/{id}")
    @ResponseBody
    public Img readImg (@PathVariable Integer id){
        return intImg.readImg(id);
    }
    
    @PutMapping ("/img/{id}/update")
    public Img updImg (@PathVariable Integer id,
                        @RequestParam ("name") String nameNew,
                        @RequestParam ("url") String urlNew){
        
        Img imgNew = intImg.readImg(id);
        
        imgNew.setName(nameNew);
        imgNew.setUrl(urlNew);

        return intImg.crtImg(imgNew);
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
