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
    public  String categoria;
    
    public Categoria(){};
    
    public Categoria(Long id , String categoria){
        this.id = id;
        this.categoria = categoria;
    }
    
}
