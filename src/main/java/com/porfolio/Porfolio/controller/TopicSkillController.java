
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.service.ITopicSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicSkillController {
    
    @Autowired
    ITopicSkillService intTopi;
    
}
