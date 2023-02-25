
package com.porfolio.Porfolio.service;

import com.porfolio.Porfolio.model.Item;
import com.porfolio.Porfolio.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService implements IItemService {

    @Autowired
    ItemRepository itemRepo;
    
    @Override
    public Item crtItem(Item item) {
        return itemRepo.saveAndFlush(item);
    }

    @Override
    public Item readItem(Integer id) {
        return itemRepo.findById(id).orElse(null);
    }

    @Override
    public void delItem(Integer id) {
        itemRepo.deleteById(id);
    }

    @Override
    public List<Item> ReadAllItem() {
        return itemRepo.findAll();
    }
    
}
