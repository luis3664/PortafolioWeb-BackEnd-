
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Certificate;
import com.porfolio.Porfolio.service.ICertificateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CertificateController {
    
    @Autowired
    ICertificateService intCerti;
    
    @PostMapping ("/certificate/add")
    public Certificate saveCerti (@RequestBody Certificate certi){
        return intCerti.crtCertificate(certi);
    }
    
    @GetMapping ("/certificate/{id}")
    @ResponseBody
    public Certificate readCerti (@PathVariable Integer id){
        return intCerti.readCertificate(id);
    }
    
    @PutMapping ("/certificate/{id}/update")
    @ResponseBody
    public Certificate updCerti (@PathVariable Integer id,
                        @RequestBody Certificate certi){
        
        Certificate certiNew = intCerti.readCertificate(id);
        
        certiNew.setDate(certi.getDate());
        certiNew.setUrlCertificate(certi.getUrlCertificate());

        return intCerti.crtCertificate(certiNew);
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
