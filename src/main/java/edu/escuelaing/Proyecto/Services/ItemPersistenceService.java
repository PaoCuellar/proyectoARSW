/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Services;

import edu.escuelaing.Proyecto.Persistence.ItemPersistence;
import edu.escuelaing.Proyecto.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */

@Service
public class ItemPersistenceService {
    @Autowired
    ItemPersistence service;

    public Item findById(Long id){
        return service.getOne(id);
    }
    
    public List<Item> getAll(){
        return service.findAll();
    }
    
    public void create(Item Item){
        service.save(Item);
    }
    
    public void update(Item item){
        Item ItemToUpdate = service.getOne(item.getId());
        item.setName(ItemToUpdate.getName());
        item.setPriceSold(ItemToUpdate.getPriceSold());
        item.setHopedPrice(ItemToUpdate.getHopedPrice());
        item.setDescription(ItemToUpdate.getDescription());
    }
    
    public void delete(Long id){
        service.deleteById(id);
    }

}