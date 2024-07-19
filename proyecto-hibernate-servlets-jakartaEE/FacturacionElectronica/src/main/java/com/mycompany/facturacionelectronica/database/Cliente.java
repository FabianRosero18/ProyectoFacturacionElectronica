/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;


import jakarta.persistence.*;

//entidad para la tabla cliente de la base de datos utilizada.

//anotaciones para indicar que esta clase es una entidad de la tabla cliente, osea que es quien tendra los parametros de la tabla
@Entity
@Table(name = "cliente")
public class Cliente {
    //con esto indicamos que es la clave primaria
    @Id
    private int idCliente;
    private String tipoId;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String matriculaMercantil;
    private String responsFinancieras;
    private String formaPago;
    private String correoFe;

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setMatriculaMercantil(String matriculaMercantil) {
        this.matriculaMercantil = matriculaMercantil;
    }

    public void setResponsFinancieras(String responsFinancieras) {
        this.responsFinancieras = responsFinancieras;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setCorreoFe(String correoFe) {
        this.correoFe = correoFe;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    public String getTelefono (){
        return telefono;
    }

}
    