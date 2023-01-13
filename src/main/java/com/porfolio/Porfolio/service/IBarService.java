
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Bar;
import java.util.List;

public interface IBarService {
    
    // CRUD
    public void crtBar (Bar bar);
    public Bar readBar (Integer id);
    public void delBar (Integer id);
    public List<Bar> ReadAllBar ();
}
