/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import com.mycompany.facturacionelectronica.controller.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author COMERCIAL
 */
public class BdCliente {
        
        private Conexion cn = new Conexion();
        private int idCliente;
        private Statement st;
        private ResultSet rs;
        
    public BdCliente(int cliente) {
        
        this.idCliente=cliente;
        
        this.consultaCliente();
    }


    public void consultaCliente(){
        
        try {
            st=cn.con.createStatement();                                    
            rs=st.executeQuery("SELECT * FROM `cliente` WHERE idCliente = "+this.idCliente);
            
        } catch (SQLException e) {
        }
        
    }
    public ResultSet resultadoConsulta(){
        return rs;
    }


    public void cerrarConexion() throws SQLException{
        cn.con.close();
    }
        
}
