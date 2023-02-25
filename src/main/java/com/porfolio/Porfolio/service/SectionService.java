
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Section;
import com.porfolio.Porfolio.repository.SectionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService implements ISectionService {

    @Autowired
    SectionRepository secRepo;
    
    @Override
    public Section crtSection(Section sec) {
        return secRepo.saveAndFlush(sec);
    }

    @Override
    public Section readSection(Integer id) {
        return secRepo.findById(id).orElse(null);
    }

    @Override
    public void delSection(Integer id) {
        secRepo.deleteById(id);
    }

    @Override
    public List<Section> ReadAllSection() {
        return secRepo.findAll();
    }
    
}
