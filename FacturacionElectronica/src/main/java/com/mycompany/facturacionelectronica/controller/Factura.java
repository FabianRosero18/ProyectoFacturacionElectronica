/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.controller;
import com.mycompany.facturacionelectronica.database.*;
import java.sql.SQLException;

public class Factura {
    
    private String observaciones;
    private BdFactura bdfactura;
    private BdItem bditem = new BdItem();
    private int idFactura,iva,retefuente,total;

    public Factura(String observaciones, String idFactura) throws SQLException {
        
        this.observaciones = observaciones;
        this.idFactura = Integer.parseInt(idFactura);
        
        this.bditem.sumaItems(this.idFactura);
        
        calculoValores();
        enviarDatosFactura();
        
    }
    public void calculoValores(){
        
        int sumatoria = this.bditem.getSumatoria();
        
        this.iva = (int) (sumatoria*0.19);
        this.retefuente = (int) (sumatoria * 0.025);
        this.total = (sumatoria + this.iva)-this.retefuente;
        
    }
    public void enviarDatosFactura() throws SQLException{
        this.bdfactura = new BdFactura(this.idFactura,this.observaciones,this.iva,this.retefuente,this.total);
    }

    public int getIva() {
        return iva;
    }

    public int getRetefuente() {
        return retefuente;
    }

    public int getTotal() {
        return total;
    }
    
    
}
