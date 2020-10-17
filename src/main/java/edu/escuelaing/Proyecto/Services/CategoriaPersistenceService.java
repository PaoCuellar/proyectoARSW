/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Services;

import edu.escuelaing.Proyecto.Persistence.CategoriaPersistence;
import edu.escuelaing.Proyecto.model.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */

@Service
public class CategoriaPersistenceService {
    @Autowired
    CategoriaPersistence service;

    public Categoria findById(Long id){
        return service.getOne(id);
    }
    
    public List<Categoria> getAll(){
        return service.findAll();
    }
    
    public Categoria create(Categoria Categoria){
        return service.save(Categoria);
    }
    
    public void delete(Long id){
        service.deleteById(id);
    }
}
