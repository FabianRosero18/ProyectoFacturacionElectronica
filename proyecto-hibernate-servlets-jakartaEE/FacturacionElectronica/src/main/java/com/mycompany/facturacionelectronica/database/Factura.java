/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Entity
@Table(name = "factura")
public class Factura {
    @Id
    //esta anotacion indica que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ya que el id de la factura tiene un nombre diferente a la entidad, se debe especificar
    @Column(name="idFactura")
    //IMPORTANTE, si es autoincremental, se debe inicializar, y es preferible que sea tipo Long
    private Long id = 1L;
    
    private String fechaRealizacion;
    private String fechaVencimiento;
    private String ordenCompra;
    private String remision;
    private String observaciones;
    private int iva;
    private int retefuente;
    private int total;
    //esta anotacion indica una relacion de muchos a uno, y que su llave foranea sera el id del cliente
    @ManyToOne
    //se debe unir al nombre de la columna de la tabla
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    public Factura() {
    }

    
  public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getRemision() {
        return remision;
    }

    public void setRemision(String remision) {
        this.remision = remision;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getRetefuente() {
        return retefuente;
    }

    public void setRetefuente(int retefuente) {
        this.retefuente = retefuente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
