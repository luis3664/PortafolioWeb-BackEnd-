
package com.porfolio.Porfolio.repository;

import com.porfolio.Porfolio.model.TopicSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicSkillRepository extends JpaRepository <TopicSkill, Integer> {
    
}
