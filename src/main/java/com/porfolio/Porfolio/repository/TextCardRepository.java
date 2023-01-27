
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.TextCard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TextCardRepository extends JpaRepository <TextCard, Integer> {
    
}
