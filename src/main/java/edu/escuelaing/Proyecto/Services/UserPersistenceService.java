/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Services;

import edu.escuelaing.Proyecto.Persistence.UserPersistence;
import edu.escuelaing.Proyecto.model.Item;
import edu.escuelaing.Proyecto.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class UserPersistenceService {
    
    
    @Autowired
    UserPersistence service;

    public User findById(Long id){
        return service.getOne(id);
    }
    
    public User findByUserName(String name){
        ArrayList<User> users = (ArrayList<User>) getAll();
        User Resp = null;
        for (User user: users){
            if(user.getUserName().equals(name)){
                Resp = user;
                break;
            }
        }
        return Resp;
    }
    
    public List<User> getAll(){
        return service.findAll();
    }
    
    public void create(User user){
        service.save(user);
    }
    
    public List<Item> getUserProductsPublished(Long id){
        return findById(id).getItems();
    }
    
    public void update(User user){
        User UserToUpdate = service.getOne(user.getId());
        user.setName(UserToUpdate.getName());
        user.setPhone(UserToUpdate.getPhone());
        user.setUserName(UserToUpdate.getUserName());
    }
    
    public void delete(Long id){
        service.deleteById(id);
    }

}
