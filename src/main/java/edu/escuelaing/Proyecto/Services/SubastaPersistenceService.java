/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Services;

import edu.escuelaing.Proyecto.Persistence.SubastaPersistence;
import edu.escuelaing.Proyecto.model.ExceptionModel;
import edu.escuelaing.Proyecto.model.Subasta;
import edu.escuelaing.Proyecto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author diego
 */
@Service
public class SubastaPersistenceService {
    @Autowired
    SubastaPersistence service;
    
    public Subasta findById(Long id){
        System.out.println("PUSH FIND "+id);
        System.out.println("PUSH FIND "+service.getOne(id).highestPush);
        return service.getOne(id);
    }
    
    @Cacheable("subastas")
    public List<Subasta> getAll(){
        return service.findAll();
    }
    
    public Subasta create(Subasta Subasta){
        
        return service.save(Subasta);
    }
    
    public void update(Subasta subasta){
        Subasta SubastaToUpdate = service.getOne(subasta.getId());
        try {
            subasta.changeHighestPush(SubastaToUpdate.getHighestPush());
        } catch (ExceptionModel ex) {
            Logger.getLogger(SubastaPersistenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Subasta push(Long subasta_id,Long push,Usuario user){
        Subasta subasta = service.getOne(subasta_id);
        try {
            subasta = service.getOne(subasta_id);
            subasta.setUserWinning(user);
            subasta.setHighestPush(push);
            System.out.println("PUSH CHECK "+subasta_id);
            service.save(subasta);
        } catch (ExceptionModel exceptionModel) {
            exceptionModel.printStackTrace();
        }
        System.out.println("PUSH CHECK "+subasta.highestPush);
        return subasta;
    }
    
    public void delete(Long id){
        service.delete(service.getOne(id));
    }
    
    public List<Subasta> getSubastabyUser(Long userId){
        List <Subasta> subastas = service.findAll();
        List <Subasta> resp =  new ArrayList<>();
        for (Subasta subasta: subastas){
            if (subasta.getUser().getId().equals(userId)){
                resp.add(subasta);
            }
        }
        return resp;
    }
}
