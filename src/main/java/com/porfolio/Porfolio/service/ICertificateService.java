
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Certificate;
import java.util.List;

public interface ICertificateService {
    
    // CRUD
    public void crtCertificate (Certificate certif);
    public Certificate readCertificate (Integer id);
    public void delCertificate (Integer id);
    public List<Certificate> ReadAllCertificate ();
}
