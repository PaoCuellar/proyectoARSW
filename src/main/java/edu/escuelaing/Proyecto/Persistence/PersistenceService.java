/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Persistence;

import edu.escuelaing.Proyecto.model.*;

/**
 *
 * @author diego
 */
public interface PersistenceService {
    
    public void SaveUser(User user);
    
    public void SaveItem(Item item);
    
    public void SaveSubasta(Subasta subasta);
}
