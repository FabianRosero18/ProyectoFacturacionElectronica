/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.Loggin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author COMERCIAL
 */
@WebServlet(name = "SvLoggin", urlPatterns = {"/SvLoggin"})
public class SvLoggin extends HttpServlet {

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
