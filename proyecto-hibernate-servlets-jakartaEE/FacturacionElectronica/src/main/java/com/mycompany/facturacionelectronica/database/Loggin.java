/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import jakarta.persistence.*;
import jakarta.persistence.Table;


/* Entidad de persistencia de la tabla usuario de la base de datos en cuestion*/

//anotaciones para indicar que esta clase es una entidad de la tabla usuario, osea que es quien tendra los parametros de la tabla
@Entity
@Table(name = "usuario")
public class Loggin {
    
    //con esto indicamos que es la clave primaria    
    @Id
    //con esto indicamos que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String usuario;
    private String contrasenia;

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
           
}
