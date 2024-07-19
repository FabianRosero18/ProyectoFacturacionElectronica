/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;

import com.mycompany.facturacionelectronica.database.*;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 * 
 * cotrolador de la entidad Item de a base de datos, realiza la insercion de lo digitado en el formulario de factura en la seccion de items
 */
public class CtrlItem {
    
   private String codigo;
   private String descripcion;
   private int cantidad;
   private int valor;
   private long idFactura;
   private EntityManager em;


    public CtrlItem(String codigoItem, String descripcionItem, String cantidadItem, String valorItem, long idFactura) {
        this.em = JpaUtil.getEntityManager();
        this.codigo = codigoItem;
        this.descripcion = descripcionItem;
        this.cantidad = Integer.parseInt(cantidadItem);
        this.valor= Integer.parseInt(valorItem);
        this.idFactura = idFactura;
        AgregarItem();
    }
    
    public final void AgregarItem(){
        
        //importante, si lleva clave foranea, se debe buscar el objeto completo y pasarlo al objeto de la entidad con el set
        Factura factura = em.find(Factura.class, idFactura);
        try {
            
            em.getTransaction().begin();
            Item item = new Item (codigo,descripcion,cantidad,valor);
            //importante, si lleva clave foranea, se debe buscar el objeto y pasarlo al objeto de la entidad con el set
            item.setFactura(factura);
            em.persist(item);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
}
