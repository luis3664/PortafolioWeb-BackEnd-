
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.TextCard;
import java.util.List;


public interface ITextCardService {
    
    // CRUD
    public TextCard crtText (TextCard text);
    public TextCard readText (Integer id);
    public void delText (Integer id);
    public List<TextCard> ReadAllText ();
    
}
