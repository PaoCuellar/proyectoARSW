/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import com.mongodb.BasicDBObject;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class User {
    private int id;
    public String userName;
    public String phone;
    public String Email;
    public ArrayList<Item> Items = new ArrayList<>();
    public ArrayList<Item> ItemsPushed = new ArrayList<>();
    public ArrayList<Subasta> subastas = new ArrayList<>();
    
    public User (String userName, String phone, String Email){
        this.userName = userName;
        this.phone = phone;
        this.Email = Email;        
    }
    
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public String getEmail(){
        return this.Email;
    }
    
    public ArrayList getItems(){
        return this.Items;
    }
    
    public ArrayList getPushedItems(){
        return this.ItemsPushed;
    }
    
    public ArrayList getSubastas(){
        return this.subastas;
    }
    
    
}
