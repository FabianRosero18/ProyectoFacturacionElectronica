/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;

import com.mycompany.facturacionelectronica.database.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author COMERCIAL
 */
public class Item {
    
    private BdItem bdItem;
    private BdFactura bdFactura;
    private ResultSet rs;

    
    public Item(String idFactura, String fechaRealizacion, String fechaVencimiento, String ordenCompra, String remision, String codigoItem, String descripcionItem, String cantidadItem, String valorItem, String idCliente) throws SQLException {
        
        this.bdFactura = new BdFactura(idFactura,fechaRealizacion,fechaVencimiento,ordenCompra,remision,idCliente);   
        this.bdItem = new BdItem(codigoItem,descripcionItem,cantidadItem,valorItem,idFactura);
        
    }

}
