/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author COMERCIAL
 */
@WebServlet(name = "SvItem", urlPatterns = {"/SvItem"})
public class SvItem extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var idFactura = request.getParameter("idFactura");
        var fechaRealizacion = request.getParameter("fechaRealizacion");
        var fechaVencimiento = request.getParameter("fechaVencimiento");
        var ordenCompra = request.getParameter("ordenCompra");
        var remision = request.getParameter("remision");
        var codigoItem = request.getParameter("codigoItem");
        var descripcionItem = request.getParameter("descripcionItem");
        var cantidadItem = request.getParameter("cantidadItem");
        var valorItem = request.getParameter("valorItem");
        //se necesita volver a capturar el dato del cliente para crear la factura, ya que es su llave foranea
        var idCliente = request.getParameter("idCliente");
        //campos capturados del cliente para volverlos a cargar en el JSP
        var nombre = request.getParameter("nombre");
        var direccion = request.getParameter("direccion");
        var telefono = request.getParameter("telefono");
        var ciudad = request.getParameter("ciudad");
        
        try {
            Item item = new Item(idFactura,fechaRealizacion,fechaVencimiento,ordenCompra,remision,codigoItem,descripcionItem,cantidadItem,valorItem,idCliente);
            
            response.sendRedirect("FacturaElectronic.jsp?idFactura="+idFactura+"&fechaRealizacion="+fechaRealizacion+
                    "&fechaVencimiento="+fechaVencimiento+"&ordenCompra="+ordenCompra+"&remision="+remision+"&nombre="+nombre+"&direccion="+direccion
                    +"&telefono="+telefono+"&ciudad="+ciudad+"&idCliente="+idCliente);
            
        } catch (SQLException ex) {
            Logger.getLogger(SvItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
