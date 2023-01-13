
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Icon;
import java.util.List;

public interface IIconService {
    
    // CRUD
    public void crtIcon (Icon icon);
    public Icon readIcon (Integer id);
    public void delIcon (Integer id);
    public List<Icon> ReadAllIcon ();
    
}
