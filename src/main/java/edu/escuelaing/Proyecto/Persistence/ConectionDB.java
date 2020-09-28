/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Persistence;

import java.util.ArrayList;
import java.util.Iterator;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author diego
 */
public class ConectionDB {
    
    private final MongoClientURI uri;
    private final MongoClient mongoCl ;
    private final DB database;
    
    public ConectionDB() {
        this.uri = new MongoClientURI("mongodb+srv://mongodb:MongoDB29@cluster0.cgjvc.mongodb.net/Temperatures?retryWrites=true&w=majority");
        mongoCl = new MongoClient(uri);
        database = mongoCl.getDB("Cluster0");
        if (mongoCl!=null){
            System.out.println("OK");
        }
        else{
            System.out.println("FUCK");
        }
    }
   
    
    
    public void insert(String name, BasicDBObject document){
        DBCollection collection = database.getCollection(name);
	collection.insert(document);
    }
    public ArrayList getData(String name){
        ArrayList<String> Data = new ArrayList<>();
        DBCollection collection = database.getCollection(name);
	Iterator<DBObject> cursor = collection.find().iterator();
        DBObject it ;
        
        while (cursor.hasNext()){
            Data.add(cursor.next().toString());
        }
        return Data;
    }
    
    public void  dropColletion(String name){
        DBCollection collection = database.getCollection(name);
        collection.drop();
    }
    
    public void Close(){
        mongoCl.close();
    }
}
