/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Services;

import edu.escuelaing.Proyecto.Persistence.UserPersistence;
import edu.escuelaing.Proyecto.model.Item;
import edu.escuelaing.Proyecto.model.Usuario;
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

    public Usuario findById(Long id){
        return service.getOne(id);
    }
    
    public Usuario findByUsuarioName(String name){
        ArrayList<Usuario> Usuarios = (ArrayList<Usuario>) getAll();
        Usuario Resp = null;
        for (Usuario Usuario: Usuarios){
            if(Usuario.getUserName().equals(name)){
                Resp = Usuario;
                break;
            }
        }
        return Resp;
    }
    
    public List<Usuario> getAll(){
        return service.findAll();
    }
    
    public void create(Usuario Usuario){
        service.save(Usuario);
    }
    
    public List<Item> getUsuarioProductsPublished(Long id){
        return findById(id).getItems();
    }
    
    public boolean userLogin(String user, String passwd){
        return findByUsuarioName(user).comparePasswd(passwd);
    }
    
    public void update(Usuario Usuario){
        Usuario UsuarioToUpdate = service.getOne(Usuario.getId());
        Usuario.setName(UsuarioToUpdate.getName());
        Usuario.setPhone(UsuarioToUpdate.getPhone());
        Usuario.setUserName(UsuarioToUpdate.getUserName());
    }
    
    public void delete(Long id){
        service.deleteById(id);
    }

}
