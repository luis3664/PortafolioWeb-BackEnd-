
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository <Certificate, Integer> {
    
}
