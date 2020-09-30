/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author diego
 */
@Entity
@Table(
   name = "Usuario", 
   uniqueConstraints = {@UniqueConstraint(columnNames = {"user_userName"})}
)
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private final Long id;
    @Column(name="user_userName")
    private  String userName;
    @Column(name="user_name")
    private  String name;
    @Column(name="user_phone")
    private  String phone;
    @Column(name="user_email")
    private final String Email;
    @OneToMany
    @JoinColumn(name="articuloPublished_id")
    public List<Item> Items;
    @OneToMany
    @JoinColumn(name="articuloPushed_id")
    public List<Item> ItemsPushed;
    
    public User (Long id,String name,String userName, String phone, String Email){
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.phone = phone;
        this.Email = Email;        
    }
    
    public void addItemPublished(Item item){
        this.Items.add(item);
    }
    
    public void addItemPushed(Item item){
        this.ItemsPushed.add(item);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setname(String name){
        this.name = name;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    
    public Long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
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
    
    public List<Item> getItems(){
        return this.Items;
    }
    
    public List<Item> getPushedItems(){
        return this.ItemsPushed;
    }  
}
