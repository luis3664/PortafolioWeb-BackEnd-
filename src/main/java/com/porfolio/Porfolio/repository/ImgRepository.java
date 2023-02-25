
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgRepository extends JpaRepository <Img, Integer> {
    @Query
    public List<Img> findAllByUrl(String url);
}
