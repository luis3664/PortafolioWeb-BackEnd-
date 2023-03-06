
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.TopicSkill;
import com.porfolio.Porfolio.repository.TopicSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicSkillService implements ITopicSkillService {

    @Autowired
    TopicSkillRepository topRepo;
    
    @Override
    public TopicSkill crtTopic(TopicSkill topi) {
        return topRepo.saveAndFlush(topi);
    }

    @Override
    public TopicSkill readTopic(Integer id) {
        return topRepo.findById(id).orElse(null);
    }

    @Override
    public void delTopic(Integer id) {
        topRepo.deleteById(id);
    }

    @Override
    public List<TopicSkill> ReadAllTopic() {
        return topRepo.findAll();
    }
    
}
