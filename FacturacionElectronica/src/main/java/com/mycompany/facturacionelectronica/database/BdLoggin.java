/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import com.mycompany.facturacionelectronica.controller.Loggin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BdLoggin extends Loggin{
    
    private Conexion cn = new Conexion();
    private Statement st;
    private ResultSet rs;   

    public BdLoggin(String usuario, String contraseña) {
        super(usuario, contraseña);
    }

    
    public void ValidarUsuario() throws SQLException{
        this.st=cn.con.createStatement(); 
        String sql = "SELECT * FROM usuario";
        //System.out.println(sql);
        this.rs=st.executeQuery(sql);   
        
    }
    
    public ResultSet getResulado(){        
        return rs;
    }

    
    
    
}
