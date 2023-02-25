
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Section;
import java.util.List;

public interface ISectionService {
    
    // CRUD
    public Section crtSection (Section sec);
    public Section readSection (Integer id);
    public void delSection (Integer id);
    public List<Section> ReadAllSection ();
    
}
