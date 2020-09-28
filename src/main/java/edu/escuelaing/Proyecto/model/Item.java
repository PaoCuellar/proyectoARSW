/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

/**
 *
 * @author diego
 */
public class Item {
    public String id;
    private int hopedPrice;
    private int PriceSold;
    private boolean sold;
    public String description;
    public String name;
    
    public Item(String name, String description,int hopedPrice,User user){
        this.id = user.userName+"_"+name;
        this.name = name;
        this.description = description;
        this.hopedPrice = hopedPrice;
        this.PriceSold = -1;
        this.sold = false;
        
    }
    
    public void Sold(){
        this.sold = true;
    }
    
    public void PriceSold(int price){
        this.PriceSold = price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public int geHopedPrice(){
        return this.hopedPrice;
    }
    
    public int getPriceSold(){
        return this.PriceSold;
    }
    
    public boolean isSold(){
        return this.sold;
    }
}
