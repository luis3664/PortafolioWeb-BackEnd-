
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.service.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateController {
    
    @Autowired
    ICertificateService intCerti;
    
}
