/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.controllers;

import edu.escuelaing.Proyecto.Services.UserPersistenceService;
import edu.escuelaing.Proyecto.model.Credenciales;
import edu.escuelaing.Proyecto.model.Usuario;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */
@RestController
@RequestMapping(value = "/subastas")
public class SubastaController {
    
    @Autowired
    UserPersistenceService UserService;
    
    
    @GetMapping("/{user}/{passwd}")
    public ResponseEntity<?> getLoginUser(@PathVariable String user,@PathVariable String passwd){
        UserService.userLogin(user, passwd);
        Usuario usuario = UserService.findByUserName(user);
        System.out.println(user+" "+passwd+" "+usuario.getUserName());
        return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credenciales c){
    	try {
	 		return new ResponseEntity<>(UserService.login(c), HttpStatus.OK);
	 	} catch (Exception ex) {
	 		Logger.getLogger(SubastaController.class.getName()).log(Level.SEVERE, null, ex);
	 		return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
	 	}
    }
    
    
    

    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewClient(@RequestBody String client){
        JSONObject jsonObject = new JSONObject(client);
        UserService.create(new Usuario(Long.parseLong(jsonObject.getString("id")),jsonObject.getString("name"),jsonObject.getString("passwd"),jsonObject.getString("userName"),jsonObject.getString("phone"),jsonObject.getString("Email"),jsonObject.getString("ciudad")));
        return new ResponseEntity<>(HttpStatus.CREATED);       
    }
    
}
