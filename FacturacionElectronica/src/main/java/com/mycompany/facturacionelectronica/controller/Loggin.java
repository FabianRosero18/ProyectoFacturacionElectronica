/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;

import com.mycompany.facturacionelectronica.database.BdLoggin;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author COMERCIAL
 */
public class Loggin {
    
    protected String usuario,contraseña;
    private BdLoggin bd;
    private ResultSet resultado;
    private boolean ingreso;

    public Loggin(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public void validacion() throws SQLException{
        
        this.bd = new BdLoggin(this.usuario,this.contraseña);
        this.bd.ValidarUsuario();
        this.resultado = bd.getResulado();
        
        while (resultado.next()) {
            
            System.out.println("user = "+resultado.getString("usuario")+" Password = "+resultado.getString("contraseña"));
            System.out.println("user digitado = "+this.usuario+" pass digitado = "+this.contraseña);
            
            if(this.usuario.equals(resultado.getString("usuario"))){
                
                System.out.println("user correcto");
                if(this.contraseña.equals(resultado.getString("contraseña"))){
                    
                    System.out.println("user y pass correcto");
                    this.ingreso = true;
                }
                else{
                    System.out.println("incorrecto alguna cosa");
                    this.ingreso = false;
                }  
            }

        }
        //ingreso = false;
    }
    public boolean getValidacion (){
        return this.ingreso;
    }
    
    
}
