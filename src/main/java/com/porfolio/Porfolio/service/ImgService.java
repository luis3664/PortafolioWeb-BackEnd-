
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Img;
import com.porfolio.Porfolio.repository.ImgRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgService implements IImgService {

    @Autowired
    ImgRepository imgRepo;
    
    @Override
    public void crtImg(Img img) {
        imgRepo.save(img);
    }

    @Override
    public Img readImg(Integer id) {
        return imgRepo.findById(id).orElse(null);
    }

    @Override
    public void delImg(Integer id) {
        imgRepo.deleteById(id);
    }

    @Override
    public List<Img> ReadAllImg() {
        return imgRepo.findAll();
    }
    
}
