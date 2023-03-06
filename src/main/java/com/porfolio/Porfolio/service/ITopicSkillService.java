
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.TopicSkill;
import java.util.List;

public interface ITopicSkillService {
    
    // CRUD
    public TopicSkill crtTopic (TopicSkill topi);
    public TopicSkill readTopic (Integer id);
    public void delTopic (Integer id);
    public List<TopicSkill> ReadAllTopic ();
    
}
