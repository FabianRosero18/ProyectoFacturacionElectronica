/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.CtrlCliente;
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
@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        var idCliente = request.getParameter("idCliente");
            CtrlCliente cl = new CtrlCliente(Integer.parseInt(idCliente));
            String nombre = cl.getNombre();
            String direccion = cl.getDireccion();
            String telefono = cl.getTelefono();
            String ciudad = cl.getCiudad();
                        
            response.sendRedirect("FacturaElectronic.jsp?idCliente="+idCliente+"&nombre="+nombre+"&direccion="+direccion+"&telefono="+telefono+"&ciudad="+ciudad);
            

            //db.cerrarConexion();        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            
            var factura = request.getParameter("factura");
            if(factura.equals("factura")){
                response.sendRedirect("FacturaElectronic.jsp");
                return;
            }
            
            var idCliente = request.getParameter("idCliente");
            var tipoId = request.getParameter("tipoId");
            var nombre = request.getParameter("nombre");
            var direccion = request.getParameter("direccion");
            var telefono = request.getParameter("telefono");
            var ciudad = request.getParameter("ciudad");
            var matriculaMercantil = request.getParameter("matriculaMercantil");
            var responsFinancieras = request.getParameter("responsFinancieras");
            var formaPago = request.getParameter("formaPago");
            var correoFe = request.getParameter("correoFe");
            
            CtrlCliente cliente = new CtrlCliente(idCliente, tipoId, nombre, direccion, telefono, ciudad, matriculaMercantil, responsFinancieras, formaPago, correoFe);
            cliente.crearCliente();
            response.sendRedirect("CreacionCliente.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
