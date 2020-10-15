/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue
    @Column(name="category_id")
    private  Long id;
    @Column(name = "category")
    public  String category;
    @Column(name = "description")
    public String description;
    
    public Categoria(){};
    
    public Categoria(Long id , String category, String description){
        this.id = id;
        this.category = category;
        this.description = description;
    }

    public Long getId(){
        return this.id;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDescription(){
        return this.description;
    }

    public void setCategory(String cate){
        this.category = cate;
    }

    public void setDescription(String descri){
        this.description = descri;
    }
    
}
