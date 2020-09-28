/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Subasta {
    public final Item item; //Item que se va a subastar
    public User user; //Usuario que esta subastando el item
    public int highestPush; // Puja mas alta hasta el momento si no hay niguna el valor es cero y se la subasta se marca como fallida
    //image
    public String id;
    
    public Subasta(Item item, User user){
        this.id = user.userName+"_"+item.name ;
        this.item = item;
        this.user = user;
        this.highestPush = 0;
    }
    
    
    public void changeHighestPush(int newPush) throws ExceptionModel{
        if(newPush <= this.highestPush){
            throw new ExceptionModel("the value needs to be higher");
        }
        else{
            this.highestPush = newPush;
        }
    }
    
    public Item getItem(){
        return this.item;
    }
    
    public User getUser(){
        return this.user;
    }
    
    public int getHighestPush(){
        return this.highestPush;
    }
    
    private void setuser(User user){
        this.user = user;
    }
    
    
}
