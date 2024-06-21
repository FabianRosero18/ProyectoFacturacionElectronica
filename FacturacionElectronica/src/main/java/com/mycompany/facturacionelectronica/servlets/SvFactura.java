/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.Factura;
import com.mycompany.facturacionelectronica.database.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COMERCIAL
 */
@WebServlet(name = "SvFactura", urlPatterns = {"/SvFactura"})
public class SvFactura extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        

        var observaciones = request.getParameter("observaciones");
        var idFactura = request.getParameter("idFactura");
        
        
        try {
            Factura factura = new Factura(observaciones,idFactura);
            int iva = factura.getIva();
            int retefuente = factura.getRetefuente();
            int total = factura.getTotal();
            
            response.sendRedirect("FacturaElectronic.jsp?iva="+iva+"&retefuente="+retefuente+"&total="+total);
            
        } catch (SQLException ex) {
            Logger.getLogger(SvFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
