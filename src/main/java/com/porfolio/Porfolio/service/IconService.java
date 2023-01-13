
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Icon;
import com.porfolio.Porfolio.repository.IconRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconService implements IIconService {
    
    @Autowired
    IconRepository iconRepo;

    @Override
    public void crtIcon(Icon icon) {
        iconRepo.save(icon);
    }

    @Override
    public Icon readIcon(Integer id) {
        return iconRepo.findById(id).orElse(null);
    }

    @Override
    public void delIcon(Integer id) {
        iconRepo.deleteById(id);
    }

    @Override
    public List<Icon> ReadAllIcon() {
        return iconRepo.findAll();
    }
    
}
