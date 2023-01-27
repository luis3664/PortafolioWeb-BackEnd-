
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Certificate;
import com.porfolio.Porfolio.service.ICertificateService;
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
public class CertificateController {
    
    @Autowired
    ICertificateService intCerti;
    
    @PostMapping ("/certificate/add")
    public String saveCerti (@RequestBody Certificate certi){
        intCerti.crtCertificate(certi);
        return "Certificate successfully created in directory.";
    }
    
    @GetMapping ("/certificate/{id}")
    @ResponseBody
    public Certificate readCerti (@PathVariable Integer id){
        return intCerti.readCertificate(id);
    }
    
    @PutMapping ("/certificate/{id}/update")
    public String updCerti (@PathVariable Integer id,
                        @RequestBody Certificate certi){
        
        Certificate certiNew = intCerti.readCertificate(id);
        
        certiNew.setDate(certi.getDate());
        certiNew.setUrlCertificate(certi.getUrlCertificate());
        
        intCerti.crtCertificate(certiNew);
        
        return "Updating successfully.";
    }
    
    @DeleteMapping ("/certificate/delete")
    public String delCerti (@RequestParam Integer id){
        intCerti.delCertificate(id);
        return "Certificate successfully removed from directory.";
    }
    
    @GetMapping ("/certificate/readAll")
    @ResponseBody
    public List<Certificate> readAllCerti (){
        return intCerti.ReadAllCertificate();
    }
    
}
