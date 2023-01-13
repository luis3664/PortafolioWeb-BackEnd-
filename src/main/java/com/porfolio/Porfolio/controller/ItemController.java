
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    
    @Autowired
    IItemService intItem;
    
}
