/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.CtrlFactura;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        
        //var idFactura = "1";
      
            CtrlFactura factura = new CtrlFactura(idFactura,observaciones);
            factura.insertDatosFinales();
            int iva = factura.getIva();
            int retefuente = factura.getRetefuente();
            int total = factura.getTotal();
            
            response.sendRedirect("FacturaElectronic.jsp?iva="+iva+"&retefuente="+retefuente+"&total="+total);
            
    
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
