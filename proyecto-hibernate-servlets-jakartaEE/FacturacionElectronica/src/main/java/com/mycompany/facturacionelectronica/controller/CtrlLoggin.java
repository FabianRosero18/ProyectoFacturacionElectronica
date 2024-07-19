/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;

import com.mycompany.facturacionelectronica.database.Loggin;
import com.mycompany.facturacionelectronica.database.JpaUtil;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */

/*esta clase es un controlador de la entidad de JPA de logueo, realiza la consulta y a la vez realiza la validacion del usuario y contraseña 
en caso de ser correcto o incorrecto retorna un booleano
*/
public class CtrlLoggin {
    
    protected String usuario,contraseña;
    private boolean ingreso;

    public CtrlLoggin(String usuario, String contraseña) throws SQLException {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.validacion();
    }
    private void validacion() throws SQLException{
        

        EntityManager em = JpaUtil.getEntityManager();
        List<Loggin> usuarios = em.createQuery("select u from Loggin u",Loggin.class).getResultList();
        
        usuarios.forEach(user -> {
            
            System.out.println("user = "+user.getUsuario()+" Password = "+user.getContrasenia());
            System.out.println("user digitado = "+this.usuario+" pass digitado = "+this.contraseña);
            
            if(this.usuario.equals(user.getUsuario())){
                System.out.println("user correcto");
                
                if(this.contraseña.equals(user.getContrasenia())){
                    
                    System.out.println("user y pass correcto");
                    this.ingreso = true;
                    
                }
                else{
                    System.out.println("incorrecto alguna cosa");
                    this.ingreso = false;
                }
                
            }
        });

    }
    public boolean getValidacion (){
        return this.ingreso;
    }
    
    
}
