/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.controllers;

import edu.escuelaing.Proyecto.Services.UserPersistenceService;
import edu.escuelaing.Proyecto.Services.ItemPersistenceService;
import edu.escuelaing.Proyecto.Services.CategoriaPersistenceService;
import edu.escuelaing.Proyecto.Services.SubastaPersistenceService;
import edu.escuelaing.Proyecto.model.Credenciales;
import edu.escuelaing.Proyecto.model.Usuario;
import edu.escuelaing.Proyecto.model.Item;
import edu.escuelaing.Proyecto.model.Categoria;
import edu.escuelaing.Proyecto.model.Subasta;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author diego
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/subastas")
public class SubastaController {
    
    @Autowired
    UserPersistenceService UserService;

    @Autowired
    ItemPersistenceService ItemService;

    @Autowired
    CategoriaPersistenceService CategoryService;
    
    @Autowired
    SubastaPersistenceService SubastaService;
    
    @Autowired
    SimpMessagingTemplate msgt;

    
    
    @GetMapping("/{user_Id}")
    public ResponseEntity<?> getLoginUser(@PathVariable String user_Id){
        Usuario usuario = UserService.findById(Long.parseLong(user_Id));
        return new ResponseEntity<>(usuario, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/user/subastas")
    public ResponseEntity<?> getUserSubastasPublished(@RequestBody String user_id){
        JSONObject json = new JSONObject(user_id);
        return new ResponseEntity<>(SubastaService.getSubastabyUser(Long.parseLong(json.getString("user_id"))),HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/subasta/{subasta_id}")
    public ResponseEntity<?> getSubastaById(@PathVariable String subasta_id){
        System.out.println(subasta_id);
        return new ResponseEntity<>(SubastaService.findById(Long.parseLong(subasta_id)),HttpStatus.ACCEPTED);
    }
    
    
    @GetMapping("/user/items")
    public ResponseEntity<?> getUserItems(@RequestBody String user_id){
        JSONObject json = new JSONObject(user_id);
        return new ResponseEntity<>(UserService.findById(Long.parseLong(json.getString("user_id"))).getItems(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/item")
    public ResponseEntity<?> getUserItem(@RequestBody String user_id){
        JSONObject json = new JSONObject(user_id);
        Usuario user = UserService.findById(Long.parseLong(json.getString("user_id")));
        ItemService.getItembyUser(user, Long.parseLong(json.getString("item_id")));
        return new ResponseEntity<>(ItemService.getItembyUser(user, Long.parseLong(json.getString("item_id"))) ,HttpStatus.ACCEPTED);
    }

    @GetMapping("/items")
    public ResponseEntity<?> getItems( ){
        return new ResponseEntity<>(ItemService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> getUsuarios( ){
        return new ResponseEntity<>(UserService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/categorias")
    public ResponseEntity<?> getCategorias( ){
        return new ResponseEntity<>(CategoryService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping("")
    public ResponseEntity<?> getSubastas(){
        return new ResponseEntity<>(SubastaService.getAll() ,HttpStatus.ACCEPTED);
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
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario u){
        try {
            return new ResponseEntity<>(UserService.create(u), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(SubastaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo registrar", HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/createItem")
    public ResponseEntity<?> createItem(@RequestBody String data){
        try {
            JSONObject json = new JSONObject(data);
            Usuario user = UserService.findById(Long.parseLong("10191919"));
            int subastaID = user.getItems().size()+1;
            String id = String.valueOf(String.valueOf("10191919"+subastaID));
            Item item =new Item(Long.parseLong(id),json.getString("name"),json.getString("description"),json.getLong("hopedPrice"),user);
            user.addItemPublished(item);
            Item it = ItemService.create(item);
            UserService.updateU(user);
            return new ResponseEntity<>(it, HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(SubastaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo agregar item", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody Categoria categoria){
        try {
            return new ResponseEntity<>(CategoryService.create(categoria), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(SubastaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo agregar categoria", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createSubasta")
    public ResponseEntity<?> createSubasta(@RequestBody Subasta subasta){
        try {
            
            return new ResponseEntity<>(SubastaService.create(subasta), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(SubastaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo publicar la subasta", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/subasta/push")
    public ResponseEntity<?> PushSubasta(@RequestBody String data){
        try {
            System.out.println(data);
            JSONObject json = new JSONObject(data);
            
            return new ResponseEntity<>(SubastaService.push(json.getLong("subasta_id"),json.getLong("push"),UserService.findById(json.getLong("user_id"))), HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(SubastaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo hacer la puja", HttpStatus.BAD_REQUEST);
        }
    }

//se puede borrar...
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewClient(@RequestBody String client){
        JSONObject jsonObject = new JSONObject(client);
        UserService.create(new Usuario(Long.parseLong(jsonObject.getString("id")),jsonObject.getString("name"),jsonObject.getString("passwd"),jsonObject.getString("userName"),jsonObject.getString("phone"),jsonObject.getString("Email"),jsonObject.getString("ciudad")));
        return new ResponseEntity<>(HttpStatus.CREATED);       
    }
    
    @MessageMapping("/subasta.{subastaId}")
    public void SubastaMessage(@DestinationVariable String subastaId) throws Exception {
        System.out.println("Nuevo asiento recibido en el servidor!:"+subastaId);
        Subasta s = SubastaService.findById(Long.parseLong(subastaId));
        System.out.println(s.getId());
        msgt.convertAndSend("/topic/subasta."+subastaId, s.getId());
    }
    
}
