/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Persistence;

import edu.escuelaing.Proyecto.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diego
 */
public interface CategoriaPersistence extends JpaRepository<Categoria, Long>{
    
}
