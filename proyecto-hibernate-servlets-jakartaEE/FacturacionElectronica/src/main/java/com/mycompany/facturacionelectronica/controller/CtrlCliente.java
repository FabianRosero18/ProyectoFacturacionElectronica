/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;

import com.mycompany.facturacionelectronica.database.Cliente;
import com.mycompany.facturacionelectronica.database.JpaUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * controlador de la entidad Cliente de la base de datos
 * 
 * 
 */
public class CtrlCliente {
    
    private int id;
    private String tipoId,nombre,direccion,telefono,ciudad,matriculaMercantil,responsFinancieras,formaPago,correoFe;
    private final Cliente cl;
    
    
    //este constructor es del servlet de factura, es el que inicializa y consulta los datos del cliente en la bd, para mostrar en la factura
    public CtrlCliente(int idCliente){

        EntityManager em = JpaUtil.getEntityManager();
        this.cl = em.find(Cliente.class, idCliente);
        this.declararDatos();
    }
    //este constructor viene del servlet de cliente, del modulo de creacion de cliente, inicializa los datos ingresados en formulario
    //para crear al cliente en la base de datos
    public CtrlCliente(String id, String tipoId, String nombre, String direccion, String telefono, String ciudad, String matriculaMercantil, String responsFinancieras, String formaPago, String correoFe) {
        this.id = Integer.parseInt(id);
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.matriculaMercantil = matriculaMercantil;
        this.responsFinancieras = responsFinancieras;
        this.formaPago = formaPago;
        this.correoFe = correoFe;
        this.cl = new Cliente();
    }
    
    //declaracion de los datos para mostrar en la factura
    private void declararDatos(){
        
            this.nombre = this.cl.getNombre();
            this.direccion = this.cl.getDireccion();
            this.telefono = this.cl.getTelefono();
            this.ciudad = this.cl.getCiudad();
            
    }
    //funcion que realiza la creacion del cliente en la base de datos, usando la entidad
    public void crearCliente(){
        EntityManager em = JpaUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            cl.setIdCliente(id);
            cl.setTipoId(tipoId);
            cl.setNombre(nombre);
            cl.setDireccion(direccion);
            cl.setTelefono(telefono);
            cl.setCiudad(ciudad);
            cl.setMatriculaMercantil(matriculaMercantil);
            cl.setResponsFinancieras(responsFinancieras);
            cl.setFormaPago(formaPago);
            cl.setCorreoFe(correoFe);
            em.persist(cl);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
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
