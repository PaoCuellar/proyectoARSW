/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.Persistence;


import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author diego
 */
public class ConectionDB {
    
     private static String url = "jdbc:postgresql://ec2-3-95-87-221.compute-1.amazonaws.com:5432/d2rnk26lvrnngg";
    private static String user = "ywcvbeaxykzrvs";
    private static String password = "a61b0a2fccd9cbfd39e3e70c050e872105fe5a0f71dd915a42067e65322ccaa0";
    private static Connection con = null;
    
    public static void main(String[] args) throws ClassNotFoundException{
         try {
             Connection con = getConnection();
             con.close();
         } catch (URISyntaxException ex) {
             Logger.getLogger(ConectionDB.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ConectionDB.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    private static Connection getConnection() throws URISyntaxException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    //URI dbUri = new URI(System.getenv(ConectionDB.url));

    //ConectionDB.user = dbUri.getUserInfo().split(":")[0];
    //ConectionDB.password = dbUri.getUserInfo().split(":")[1];
    //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

    return (Connection) DriverManager.getConnection(ConectionDB.url, ConectionDB.user, ConectionDB.password);
    }
}
