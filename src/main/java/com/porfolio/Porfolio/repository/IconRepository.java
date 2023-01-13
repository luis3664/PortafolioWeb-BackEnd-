
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository <Icon, Integer> {
    
}
