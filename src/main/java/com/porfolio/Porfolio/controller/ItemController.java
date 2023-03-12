
package com.porfolio.Porfolio.controller;

import com.porfolio.Porfolio.model.Certificate;
import com.porfolio.Porfolio.model.Icon;
import com.porfolio.Porfolio.model.Img;
import com.porfolio.Porfolio.model.Item;
import com.porfolio.Porfolio.model.Section;
import com.porfolio.Porfolio.model.TextCard;
import com.porfolio.Porfolio.service.ICertificateService;
import com.porfolio.Porfolio.service.IIconService;
import com.porfolio.Porfolio.service.IImgService;
import com.porfolio.Porfolio.service.IItemService;
import com.porfolio.Porfolio.service.ISectionService;
import com.porfolio.Porfolio.service.ITextCardService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ItemController {
    
    @Autowired
    IItemService intItem;
    
    @Autowired
    ICertificateService intCerti;
    
    @Autowired
    IImgService intImg;
    
    @Autowired
    ISectionService intSec;
    
    @Autowired
    IIconService intIcon;
    
    @Autowired
    ITextCardService intText;
    
    @PostMapping ("/item/add")
    @ResponseBody
    public Item saveItem (@RequestBody Item item){
        item.setTextCard(null);
        item.setImgAssigned(null);

        return intItem.crtItem(item);
    }

    @PostMapping ("/item/addC")
    @ResponseBody
    public Item saveItemC (@RequestBody Item item,
                           @RequestParam Integer idCertificate,
                           @RequestParam Integer idImg){
        List<Img> listImg = item.getImgAssigned();
        listImg.add(intImg.readImg(idImg));

        item.setCertificate(intCerti.readCertificate(idCertificate));
        item.setImgAssigned(listImg);

        Item itemNew = intItem.crtItem(item);
        addSecI(itemNew.getId(), 3);

        return itemNew;
    }

    @PostMapping ("/item/addP")
    @ResponseBody
    public Item saveItemP (@RequestBody Item item){

        List<Img> listImg = new ArrayList<Img>();
        TextCard text = intText.crtText(item.getTextCard());
        Item itemNew = new Item();

        if (item.getImgAssigned().size() > 0) {
            for (int i = 0; i < item.getImgAssigned().size(); i++) {
                List<Img> aux = intImg.findByUrl(item.getImgAssigned().get(i).getUrl());

                if (aux.size() > 0) {
                    listImg.add(aux.get(0));
                } else {
                    listImg.add(intImg.crtImg(item.getImgAssigned().get(i)));
                };
            };
        }

        itemNew.setTitle(item.getTitle());
        itemNew.setText(item.getText());
        itemNew.setImgAssigned(listImg);
        itemNew.setTextCard(text);

        itemNew = intItem.crtItem(itemNew);
        addSecI(itemNew.getId(), 1);

        return itemNew;
    }
    
    @GetMapping ("/item/{id}")
    @ResponseBody
    public Item readItem (@PathVariable Integer id){
        return intItem.readItem(id);
    }
    
    @PutMapping ("/item/update")
    public Item updItem (@RequestBody Item item){
        
        Item itemNew = intItem.readItem(item.getId());
        
        itemNew.setTitle(item.getTitle());
        itemNew.setText(item.getText());
        itemNew.setCertificate(item.getCertificate());
        itemNew.setTextCard(item.getTextCard());
        itemNew.setIconAssigned(item.getIconAssigned());
        itemNew.setImgAssigned(null);

        return intItem.crtItem(itemNew);
    }

    @PutMapping ("/item/updateP")
    @ResponseBody
    public Item updItemP (@RequestBody Item item){
        Item itemNew = intItem.readItem(item.getId());
        List<Img> listImg = new ArrayList<Img>();
        TextCard text = item.getTextCard();

        if (item.getImgAssigned().size() > 0) {
            for (int i = 0; i < item.getImgAssigned().size(); i++) {
                List<Img> aux = intImg.findByUrl(item.getImgAssigned().get(i).getUrl());

                if (aux.size() > 0) {
                    listImg.add(aux.get(0));
                } else {
                    listImg.add(intImg.crtImg(item.getImgAssigned().get(i)));
                };
            };
        };

        text = intText.crtText(text);

        itemNew.setTextCard(text);
        itemNew.setImgAssigned(listImg);

        return intItem.crtItem(itemNew);
    }

    @PutMapping ("/item/updateC")
    @ResponseBody
    public Item updtItemC (@RequestBody Item item,
                           @RequestParam Integer idCertificate,
                           @RequestParam Integer idImg){
        List<Img> listImg = item.getImgAssigned();
        listImg.add(intImg.readImg(idImg));

        item.setCertificate(intCerti.readCertificate(idCertificate));
        item.setImgAssigned(listImg);

        Item itemNew = intItem.crtItem(item);

        return itemNew;
    }
    
    @DeleteMapping ("/item/delete")
    public void delItem (@RequestParam Integer id){
        intItem.delItem(id);
    }
    
    @GetMapping ("/item/readAll")
    @ResponseBody
    public List<Item> readAllItem (){
        return intItem.ReadAllItem();
    }
    
    @PutMapping ("/item/addCerti")
    public String addCertiI (@RequestParam Integer idItem,
                        @RequestParam Integer idCerti){
        Certificate certi = intCerti.readCertificate(idCerti);
        Item item = intItem.readItem(idItem);
        
        item.setCertificate(certi);
        intItem.crtItem(item);
        
        return "Operation performed satisfactorily.";
    }
    
    @PutMapping ("/item/addImg")
    @ResponseBody
    public Item addImgI (@RequestParam Integer idItem,
                        @RequestParam Integer idImg){
        Img img = intImg.readImg(idImg);
        Item item = intItem.readItem(idItem);
        List<Img> imgList = item.getImgAssigned();
        
        imgList.add(img);
        item.setImgAssigned(imgList);

        return intItem.crtItem(item);
    }
    
    @PutMapping ("/item/addSec")
    public String addSecI (@RequestParam Integer idItem,
                        @RequestParam Integer idSec){
        Section sec = intSec.readSection(idSec);
        Item item = intItem.readItem(idItem);
        List<Item> itemList = sec.getListItem();
        
        itemList.add(item);
        sec.setListItem(itemList);
        intSec.crtSection(sec);
        
        item.setSecAssigI(sec);
        intItem.crtItem(item);

        return "Operation performed satisfactorily.";
    }
    
    @PostMapping ("/item/addIcon")
    @ResponseBody
    public String addIconI (@RequestParam Integer idItem,
                        @RequestParam Integer idIcon){
        Icon icon = intIcon.readIcon(idIcon);
        Item item = intItem.readItem(idItem);
        List<Icon> iconList = item.getIconAssigned();
        
        iconList.add(icon);
        item.setIconAssigned(iconList);
        intItem.crtItem(item);
        
        return "Operation performed satisfactorily.";
    }
    
    @DeleteMapping("/item/deleteIcon")
    public void delIconI(@RequestParam Integer idItem,
                        @RequestParam Integer idIcon){
        Icon icon = intIcon.readIcon(idIcon);
        Item item = intItem.readItem(idItem);
        List<Icon> iconList = item.getIconAssigned();
        
        iconList.remove(icon);
        item.setIconAssigned(iconList);
        intItem.crtItem(item);
    }
    
    @PutMapping ("/item/addText")
    @ResponseBody
    public Item addTextCardI (@RequestParam Integer idItem,
                            @RequestParam Integer idText){
        TextCard text = intText.readText(idText);
        Item item = intItem.readItem(idItem);
        
        item.setTextCard(text);
        return intItem.crtItem(item);
    }
        
}
