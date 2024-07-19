/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.facturacionelectronica.servlets;

import com.mycompany.facturacionelectronica.controller.CtrlItem;
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
@WebServlet(name = "SvItem", urlPatterns = {"/SvItem"})
public class SvItem extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        /* debido a las condiciones del formulario, este servlet debe hacer una insercion de los primeros datos en la
        tabla factura ademas de la insercion del item, por eso captura el valor de la id Factura ademas de los otros datos
        y los de los items*/
        long idFactura;
        int contador = Integer.parseInt(request.getParameter("contador"));
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
           
            CtrlFactura factura = new CtrlFactura(fechaRealizacion,fechaVencimiento,ordenCompra,remision,idCliente);
            System.out.println(contador);
            //este contador es una variable auxiliar para determinar que no se vaya a crear una factura nueva cada vez que se inserte un item
            //si es igual a 0 significa que es la primera vez que se ingresa, y por lo cual si debe crear la factura, sino no la va a crear, solo
            //creara los items
            if(contador == 0){
                //en caso de ser la primera vez, debe capturar la id de la factura desde el metodo getIdFactura.
                factura.InsertDatosIniciales();
                idFactura = factura.getIdFactura();
            }
            else{
                //sino, debe capturarlo a partir del parametro del input hidden llamado idFctr, el cual tiene el id
                idFactura = Long.parseLong(request.getParameter("idFctr"));
            }
            
            
            CtrlItem item = new CtrlItem(codigoItem,descripcionItem,cantidadItem,valorItem,idFactura);
            contador++;
            //Volvemos a pasar los primeros campos de la factura que fueron digitados y los campos del cliente, para volver a mostrarlos
            response.sendRedirect("FacturaElectronic.jsp?idFactura="+idFactura+"&fechaRealizacion="+fechaRealizacion+
                    "&fechaVencimiento="+fechaVencimiento+"&ordenCompra="+ordenCompra+"&remision="+remision+"&nombre="+nombre+"&direccion="+direccion
                    +"&telefono="+telefono+"&ciudad="+ciudad+"&idCliente="+idCliente+"&contador="+contador);
            
        
        
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
