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

/**
 *
 * @author diego
 */
@Entity
@Table(name="producto")
public class Item {
    @Id
    @GeneratedValue
    @Column(name="product_id")
    public Long id;
    @Column(name="hopedPrice")
    private Long hopedPrice;
    @Column(name="PriceSold")
    private Long PriceSold;
    @Column(name="sold")
    private boolean sold;
    @Column(name="desciption")
    public String description;
    @Column(name="product_name")
    public String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id", referencedColumnName = "category_id")
    private final Categoria categoria;
    
    public Item(Long id, String name, String description,Long hopedPrice,User user,Categoria categoria){
        this.id = id;
        this.name = name;
        this.description = description;
        this.hopedPrice = hopedPrice;
        this.sold = false;
        this.categoria = categoria;
        
    }
    
    public void Sold(){
        this.sold = true;
    }
    
    public void PriceSold(Long price){
        this.PriceSold = price;
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
        return this.PriceSold;
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
        this.PriceSold = price;
    }
    
    public boolean isSold(){
        return this.sold;
    }
}
