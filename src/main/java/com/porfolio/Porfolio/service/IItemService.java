
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Item;
import java.util.List;

public interface IItemService {
    
    // CRUD
    public void crtItem (Item item);
    public Item readItem (Integer id);
    public void delItem (Integer id);
    public List<Item> ReadAllItem ();
    
}
