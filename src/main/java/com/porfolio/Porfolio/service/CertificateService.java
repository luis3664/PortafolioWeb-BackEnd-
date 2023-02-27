
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Certificate;
import com.porfolio.Porfolio.repository.CertificateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService implements ICertificateService {
    
    @Autowired
    CertificateRepository certifRepo;

    @Override
    public Certificate crtCertificate(Certificate certif) {
        return certifRepo.saveAndFlush(certif);
    }

    @Override
    public Certificate readCertificate(Integer id) {
        return certifRepo.findById(id).orElse(null);
    }

    @Override
    public void delCertificate(Integer id) {
        certifRepo.deleteById(id);
    }

    @Override
    public List<Certificate> ReadAllCertificate() {
        return certifRepo.findAll();
    }
}
