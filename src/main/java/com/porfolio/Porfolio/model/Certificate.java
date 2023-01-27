
package com.porfolio.Porfolio.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Certificate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Basic
    private String urlCertificate;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    // Constructors
    public Certificate(){
    }
    public Certificate(Integer id, String urlCertificate, Date date) {
        this.id = id;
        this.urlCertificate = urlCertificate;
        this.date = date;
    }
    
}
