
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.TextCard;
import com.porfolio.Porfolio.service.ITextCardService;
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
public class TextCardController {
    
    @Autowired
    ITextCardService intText;
    
    @PostMapping ("/text/add")
    public String saveText (@RequestBody TextCard text){
        intText.crtText(text);
        return "TextCard successfully created in directory.";
    }
    
    @GetMapping ("/text/{id}")
    @ResponseBody
    public TextCard readText (@PathVariable Integer id){
        return intText.readText(id);
    }
    
    @PutMapping ("/text/{id}/update")
    public String updText (@PathVariable Integer id,
                        @RequestBody TextCard text){
        
        TextCard textNew = intText.readText(id);
        
        textNew.setText(text.getText());
        
        intText.crtText(textNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/text/delete")
    public String deltext (@RequestParam Integer id){
        intText.delText(id);
        return "TextCard successfully removed from directory.";
    }
    
    @GetMapping ("/text/readAll")
    @ResponseBody
    public List<TextCard> readAllText (){
        return intText.ReadAllText();
    }
    
}
