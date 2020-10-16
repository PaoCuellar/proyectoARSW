/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 *
 * @author diego
 */
@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    public Long id;
    @Column(name="hopedPrice")
    private Long hopedPrice;
    @Column(name="priceSold")
    private Long priceSold;
    @Column(name="sold")
    private boolean sold;
    @Column(name="desciption")
    public String description;
    @Column(name="date")
    public Date date;
    @Column(name="product_name")
    public String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id", referencedColumnName = "category_id")
    private  Categoria categoria;
    
    public Item(){};
    
    public Item(Long id, String name, String description,Long hopedPrice,Usuario user,Date date){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hopedPrice = hopedPrice;
        this.priceSold = hopedPrice;
        this.sold = false;
        this.date = date;  
    }
    
    public Long getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public Long getHopedPrice(){
        return this.hopedPrice;
    }
    
    public Long getPriceSold(){
        return this.priceSold;
    }

    public Date getDate(){
    	return this.date;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setHopedPrice(Long price){
        this.hopedPrice = price;
    }
    
    public void setPriceSold(Long price){
        this.priceSold = price;
    }
    
    public void setDate(Date date){
    	this.date = date;
    }

    public boolean isSold(){
        return this.sold;
    }
}
