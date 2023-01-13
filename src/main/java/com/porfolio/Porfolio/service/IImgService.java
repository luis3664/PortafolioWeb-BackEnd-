
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Img;
import java.util.List;

public interface IImgService {
    
    // CRUD
    public void crtImg (Img img);
    public Img readImg (Integer id);
    public void delImg (Integer id);
    public List<Img> ReadAllImg ();
    
}
