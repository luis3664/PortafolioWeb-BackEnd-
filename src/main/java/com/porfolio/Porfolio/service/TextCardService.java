
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.TextCard;
import com.porfolio.Porfolio.repository.TextCardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextCardService implements ITextCardService {
    
    @Autowired
    TextCardRepository textRepo;

    @Override
    public void crtText(TextCard text) {
        textRepo.save(text);
    }

    @Override
    public TextCard readText(Integer id) {
        return textRepo.findById(id).orElse(null);
    }

    @Override
    public void delText(Integer id) {
        textRepo.deleteById(id);
    }

    @Override
    public List<TextCard> ReadAllText() {
        return textRepo.findAll();
    }
    
}
