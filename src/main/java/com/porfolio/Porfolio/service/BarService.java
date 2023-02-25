
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Bar;
import com.porfolio.Porfolio.repository.BarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarService implements IBarService {
    
    @Autowired
    BarRepository barRepo;

    @Override
    public void crtBar(Bar bar) {
        barRepo.saveAndFlush(bar);
    }

    @Override
    public Bar readBar(Integer id) {
        return barRepo.findById(id).orElse(null);
    }

    @Override
    public void delBar(Integer id) {
        barRepo.deleteById(id);
    }

    @Override
    public List<Bar> ReadAllBar() {
        return barRepo.findAll();
    }
    
}
