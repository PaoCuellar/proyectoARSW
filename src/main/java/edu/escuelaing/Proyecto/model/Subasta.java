/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name="subasta")
public class Subasta {
    @Id
    @GeneratedValue
    @Column(name="publish_id")
    private final Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="publish_id", referencedColumnName = "product_id")
    private final Item item; //Item que se va a subastar
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="publish_id", referencedColumnName = "user_id")
    private User user; //Usuario que esta subastando el item
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="publish_id", referencedColumnName = "user_id")
    private User userWinning; //Usuario que esta subastando el item
    @Column(name="highestBit")
    public Long highestPush; // Puja mas alta hasta el momento si no hay niguna el valor es cero y se la subasta se marca como fallida
    //image
    
    public Subasta(Long id, Item item, User user){
        this.id = id;
        this.item = item;
        this.user = user;
    }
    
    
    public void changeHighestPush(Long newPush) throws ExceptionModel{
        if(newPush <= this.highestPush){
            throw new ExceptionModel("the value needs to be higher");
        }
        else{
            this.highestPush = newPush;
        }
    }
    
    public Long getId(){
        return this.id;
    }
    
    public Item getItem(){
        return this.item;
    }
    
    public User getUser(){
        return this.user;
    }
    
    public Long getHishestPush(){
        return this.highestPush;
    }
    
    public Long getHighestPush(){
        return this.highestPush;
    }
    
    private void setuser(User user){
        this.user = user;
    }
    
    
}
