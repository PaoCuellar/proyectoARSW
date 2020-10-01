/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Services;

import edu.escuelaing.Proyecto.Persistence.SubastaPersistence;
import edu.escuelaing.Proyecto.model.ExceptionModel;
import edu.escuelaing.Proyecto.model.Subasta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class SubastaPersistenceService {
    @Autowired
    SubastaPersistence service;

    public Subasta findById(Long id){
        return service.getOne(id);
    }
    
    public List<Subasta> getAll(){
        return service.findAll();
    }
    
    public void create(Subasta Subasta){
        service.save(Subasta);
    }
    
    public void update(Subasta subasta){
        Subasta SubastaToUpdate = service.getOne(subasta.getId());
        try {
            subasta.changeHighestPush(SubastaToUpdate.getHishestPush());
        } catch (ExceptionModel ex) {
            Logger.getLogger(SubastaPersistenceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(Long id){
        service.deleteById(id);
    }
}
