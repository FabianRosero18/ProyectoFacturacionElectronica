
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.CtrlLoggin;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;


@WebServlet(name = "SvLoggin", urlPatterns = {"/SvLoggin"})
public class SvLoggin extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var usuario = request.getParameter("usuario");
        var contraseña = request.getParameter("contraseña");
        
        
        try {
            
            CtrlLoggin loggin = new CtrlLoggin(usuario,contraseña);
            boolean ingreso = loggin.getValidacion();
            
            //segun el booleano de validacion, si es true redirige y muestra el menu sino muestra un mensaje de error.
            if(ingreso == true){
                response.sendRedirect("index.jsp?mensajeError= --------------------------------------------------------------- &visibBoton=hidden&visibMenu=visible");
                
            }else{
                response.sendRedirect("index.jsp?fallido=true&mensajeError=usuario o contraseña no valida&visibBoton=visible&visibMenu=hidden");
            }
            
        } catch (SQLException ex) {
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
    }

}
