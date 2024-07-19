/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import jakarta.persistence.*;

/**
 *
 * @author COMERCIAL
 */
@Entity
@Table(name = "item")
public class Item {
    
    @Id
     //esta anotacion indica que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ya que el id del item tiene un nombre diferente a la entidad, se debe especificar
    @Column(name = "idItem")
    //IMPORTANTE, si es autoincremental, se debe inicializar, y es preferible que sea tipo Long    
    private Long id = 1L;
    
    private String codigo;
    private String descripcion;
    private int cantidad;
    private int valorUnidad;
    //esta anotacion indica una relacion de muchos a uno, y que su llave foranea sera el id del cliente    
    @ManyToOne
    //se debe unir al nombre de la columna de la tabla    
    @JoinColumn(name="idFactura")
    private Factura factura; 
    
    
    public Item() {
    }

    public Item(String codigo, String descripcion, int cantidad, int valorUnidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getValorUnidad() {
        return valorUnidad;
    }

    public Factura getFactura() {
        return factura;
    }

    
}
