/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author diego
 */
@Entity
@Table(
   name = "usuario", 
   uniqueConstraints = {@UniqueConstraint(columnNames = {"user_userName"})})
public class Usuario {
    @Id
    @Column(name="user_id")
    private  Long id;
    @Column(name="user_userName")
    private  String userName;
    @Column(name="user_name")
    private  String name;
    @Column(name="user_phone")
    private  String phone;
    @Column(name="user_email")
    private  String email;
    @Column(name="password")
    private  String password;
    @Column (name="ciudad")
    private String ciudad;
    @OneToMany
    @JoinTable(
            name="items_published",
            joinColumns = @JoinColumn( name="client_ID"),
            inverseJoinColumns = @JoinColumn( name="item_ID"))
    public List<Item> Items;
    @OneToMany
    @JoinTable(
            name="items_Pushed",
            joinColumns = @JoinColumn( name="client_ID"),
            inverseJoinColumns = @JoinColumn( name="item_ID"))
    public List<Subasta> SubastasPushed;
    
    public Usuario(){};
    
    public Usuario (Long id,String name,String passwd, String userName, String phone, String email, String ciudad){
        this.id = id;
        this.name = name;
        this.password = passwd;
        this.userName = userName;
        this.phone = phone;
        this.email = email; 
        this.ciudad = ciudad;
    }
    
    public void addItemPublished(Item item){
        this.Items.add(item);
    }
    
    public void addSubastaPushed(Subasta subasta){
        this.SubastasPushed.add(subasta);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
    public void setPassword(String passwd){
        this.password = passwd;
    }

    public void setId (long id){
        this.id = id;
    }

    public void setEmail (String email){
        this.email = email;
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
        return this.email;
    }
    
    public String getCiudad(){
        return this.ciudad;
    }
    
    public List<Item> getItems(){
        return this.Items;
    }
    
    public List<Subasta> getPushedSubastas(){
        return this.SubastasPushed;
    }
    
    public boolean comparePasswd(String passwd){
        return this.password.equals(passwd);
    }
}
