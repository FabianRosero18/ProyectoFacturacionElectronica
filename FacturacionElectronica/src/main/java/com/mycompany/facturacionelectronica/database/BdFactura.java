/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.facturacionelectronica.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BdFactura {
    
    private Conexion cn = new Conexion();

    private String fechaRealizacion,fechaVencimiento,ordenCompra,remision,observaciones;
    private int idFactura,idCliente,iva,retefuente,total;
    private Statement st;
    private ResultSet rs;

    public BdFactura(String idFactura, String fechaRealizacion, String fechaVencimiento, String ordenCompra, String remision, String idCliente) throws SQLException {

        this.idFactura = Integer.parseInt(idFactura);
        this.fechaRealizacion = fechaRealizacion;
        this.fechaVencimiento = fechaVencimiento;
        this.ordenCompra = ordenCompra;
        this.remision = remision;
        this.idCliente = Integer.parseInt(idCliente);
        
        compararIdFactura();
        
    }

    public BdFactura(int idFactura, String observaciones, int iva, int retefuente, int total) throws SQLException {
        this.idFactura = idFactura;
        this.observaciones = observaciones;
        this.iva = iva;
        this.retefuente = retefuente;
        this. total = total;
        
        modificarDatosFinales();

    }
    public void compararIdFactura() throws SQLException{

        int id = 0;
        
         this.st = cn.con.createStatement();                                    
         this.rs = st.executeQuery("SELECT idFactura FROM factura ORDER BY idFactura DESC LIMIT 1");
         
         while(rs.next()){
            id = this.rs.getInt("idFactura");
        }

         if(this.idFactura > id ){
             insertarPrimerosDatos();
         }else{
             System.out.println("no se creo otra factura");
         }
    }
    public void insertarPrimerosDatos() throws SQLException{

        this.st = cn.con.createStatement();                                    
        st.executeUpdate("INSERT INTO factura (idFactura,fechaRealizacion,fechaVencimiento,ordenCompra,remision,observaciones,iva,retefuente,total,idCliente)"
                + "VALUES ("+this.idFactura+",'"+this.fechaRealizacion+"','"+this.fechaVencimiento+"','"+this.ordenCompra+"','"+this.remision+"','',0,0,0,"+this.idCliente+")");
        
       
    }
    public void modificarDatosFinales() throws SQLException{
        
        this.st = cn.con.createStatement();
        String sql = "UPDATE factura"
                + " SET observaciones='"+this.observaciones+"',iva="+this.iva+",retefuente="+this.retefuente+",total="+this.total+""
                + " WHERE idFactura="+this.idFactura+"";
        st.executeUpdate(sql);

    }
    


    
}
