/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;

import com.mycompany.facturacionelectronica.database.BdCliente;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author COMERCIAL
 */
public class Cliente {
    
    private BdCliente bd;
    private ResultSet rs;
    private String nombre,direccion,telefono,ciudad;        
    
    public Cliente(int idCliente) throws SQLException{
        
        bd = new BdCliente(idCliente);
        this.rs = bd.resultadoConsulta();
        declararDatos();
        
    }

    private void declararDatos() throws SQLException{
        
        while(rs.next()){
            this.nombre = rs.getString("nombre");
            this.direccion = rs.getString("direccion");
            this.telefono = rs.getString("telefono");
            this.ciudad = rs.getString("ciudad");
            //System.out.println(this.nombre+this.direccion+this.telefono+this.ciudad);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    
}
