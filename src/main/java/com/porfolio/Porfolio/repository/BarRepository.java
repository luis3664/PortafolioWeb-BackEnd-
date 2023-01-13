
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository <Bar, Integer> {
    
}
