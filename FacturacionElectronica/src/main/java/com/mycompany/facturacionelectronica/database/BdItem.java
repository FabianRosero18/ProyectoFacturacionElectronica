/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author COMERCIAL
 */

public class BdItem {
    
    private Conexion cn = new Conexion();

    private int valorItem,idFactura,cantidadItem,sumatoria;
    private String codigoItem,descripcionItem;
    private Statement st;
    private ResultSet rs;

    public BdItem(String codigoItem, String descripcionItem, String cantidadItem, String valorItem, String idFactura) throws SQLException {
        this.valorItem = Integer.parseInt(valorItem);
        this.idFactura = Integer.parseInt(idFactura);
        this.cantidadItem = Integer.parseInt(cantidadItem);
        this.codigoItem = codigoItem;
        this.descripcionItem = descripcionItem;
        
        insertarItem();
    }

    public BdItem() {

    }
    
    public void insertarItem () throws SQLException{
        
        this.st = cn.con.createStatement();
        String sql="INSERT INTO item (codigo,descripcion,cantidad,valorUnidad,idFactura)"
                + "VALUES('"+this.codigoItem+"','"+this.descripcionItem+"',"+this.cantidadItem+","
                +this.valorItem+","+this.idFactura+")";
        //System.out.println(sql);
        st.executeUpdate(sql);
        
    }
    public void sumaItems(int idFactura) throws SQLException{
        
        this.st = cn.con.createStatement();
        String sql = "SELECT cantidad,valorUnidad FROM item WHERE idFactura="+idFactura;
       // System.out.println(sql);
        this.rs = st.executeQuery(sql);
        int auxiliar = 0;
        this.sumatoria = 0;
        
        while (rs.next()) {
            auxiliar = this.rs.getInt("cantidad") * this.rs.getInt("valorUnidad");
            this.sumatoria = this.sumatoria+auxiliar;
        }
                        
    }
    public int getSumatoria(){
        return this.sumatoria;
    }
    
}
