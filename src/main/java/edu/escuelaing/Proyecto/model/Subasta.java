/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import java.sql.Date;
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
    @Column(name="publish_id")
    private  Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="item", referencedColumnName = "product_id")
    private  Item item; //Item que se va a subastar
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario", referencedColumnName = "user_id")
    private Usuario user; //Usuario que esta subastando el item
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userWinning", referencedColumnName = "user_id")
    private Usuario userWinning; //Usuario que esta subastando el item
    @Column(name="highestPush")
    public Long highestPush; // Puja mas alta hasta el momento si no hay niguna el valor es cero y se la subasta se marca como fallida
    //image
    @Column(name="fechaInicio")
    public Date fechaInicio;
    @Column(name="fechaFin")
    public Date fechaFin;
    
    public Subasta(){};
    
    public Subasta(Long id, Item item, Usuario user, Date fechaInicio, Date fechaFin,Long highestPush){
        this.id = id;
        this.item = item;
        this.user = user;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.highestPush = highestPush;
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
    
    public Usuario getUser(){
        return this.user;
    }
    
    public Long getHighestPush(){
        return this.highestPush;
    }

    public Date getFechaInicio(){
        return this.fechaInicio;
    }
    
    public Date getFechaFin(){
        return this.fechaFin;
    }

    public Usuario getUserWinning() {return this.userWinning;    }

    public void setUserWinning(Usuario userWinning) throws ExceptionModel {
        if(this.id.toString().equals(userWinning.getId().toString())){
            throw new ExceptionModel("you can not participate in your own items");
        }
        else{
            this.userWinning = userWinning;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setHighestPush(Long highestPush) {
        this.highestPush = highestPush;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
