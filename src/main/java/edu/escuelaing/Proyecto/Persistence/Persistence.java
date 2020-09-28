/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Persistence;

import com.mongodb.BasicDBObject;
import edu.escuelaing.Proyecto.model.Item;
import edu.escuelaing.Proyecto.model.Subasta;
import edu.escuelaing.Proyecto.model.User;

/**
 *
 * @author diego
 */
public class Persistence implements PersistenceService{
    
    ConectionDB CON;
    public Persistence(){
        this.CON = new ConectionDB();
    }
    
    @Override
    public void SaveUser(User user) {
        BasicDBObject document = new BasicDBObject();
        document.put(user.userName, user);
        CON.insert("User", document);
    }

    @Override
    public void SaveItem(Item item) {
        BasicDBObject document = new BasicDBObject();
        document.put(item.id, item);
        CON.insert("Item", document);
    }

    @Override
    public void SaveSubasta(Subasta subasta) {
        BasicDBObject document = new BasicDBObject();
        document.put(subasta.id, subasta);
        CON.insert("Subasta", document);
    }
    
}
