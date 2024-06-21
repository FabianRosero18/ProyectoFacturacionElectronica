/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.Cliente;
import com.mycompany.facturacionelectronica.controller.Loggin;
import java.io.IOException;
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
        try {
            Cliente cl = new Cliente(Integer.parseInt(idCliente));
            String nombre = cl.getNombre();
            String direccion = cl.getDireccion();
            String telefono = cl.getTelefono();
            String ciudad = cl.getCiudad();
            
            //System.out.println(nombre+direccion+telefono+ciudad);
            
            response.sendRedirect("FacturaElectronic.jsp?idCliente="+idCliente+"&nombre="+nombre+"&direccion="+direccion+"&telefono="+telefono+"&ciudad="+ciudad);
            

            //db.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var usuario = request.getParameter("usuario");
        var contraseña = request.getParameter("contraseña");
        
        Loggin loggin = new Loggin(usuario,contraseña);
        try {
            loggin.validacion();
            boolean ingreso = loggin.getValidacion();
            
            if(ingreso == true){
                response.sendRedirect("FacturaElectronic.jsp");
            }else{
                response.sendRedirect("index.jsp?mensajeError='usuario o contraseña no valida'");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SvLoggin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
