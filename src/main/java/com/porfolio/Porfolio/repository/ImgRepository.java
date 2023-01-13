
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgRepository extends JpaRepository <Img, Integer> {
    
}
