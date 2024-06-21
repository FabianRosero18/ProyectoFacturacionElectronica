
package com.mycompany.facturacionelectronica.database;

//import jakarta.jms.Connection;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author COMERCIAL
 */
public class Conexion {
    
    public Connection con;
    
    public Conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/facturaelectronica?serverTimezone=UTC","root","");
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }
    }
    
}
