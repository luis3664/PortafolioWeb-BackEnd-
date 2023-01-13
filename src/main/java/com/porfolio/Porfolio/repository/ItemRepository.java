
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository <Item, Integer> {
    
}
