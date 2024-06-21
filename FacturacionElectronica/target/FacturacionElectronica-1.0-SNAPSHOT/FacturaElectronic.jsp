<%-- 
    Document   : FacturaElectronica
    Created on : 12/06/2024, 12:13:27 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
    
    <% 
    // captura de datos del cliente, segun la id especificada   
    String idCliente = request.getParameter("idCliente");

    String nombre = request.getParameter("nombre");
    String direccion = request.getParameter("direccion");
    String telefono = request.getParameter("telefono");
    String ciudad = request.getParameter("ciudad");
    
    //si no hay una id, entonces los campos se quedan en blanco
        if(idCliente == null || nombre == null){
        idCliente = "";
        nombre= "";
        direccion= "";
        telefono = "";
        ciudad = "";
    }
    %>
       
  <link rel="stylesheet" type="text/css" href="css/crear_factura.css">
  <script src="js/crear_factura.js"></script>

    <img src="images/logo.jpg" /><br>

    <h1 id="tit1">Creacion de factura electronica</h1><br><br><br>

    <form action="SvCliente" method="GET">
    <label id="lid">ID cliente</label>
    <input type="text" id="id" name="idCliente" value="<%=idCliente%>">
    <label id="lnombre">Nombre cliente</label>
    <input type="text" id="nombre" disabled value="<%=nombre%>">
    <label id="ldir">Direccion</label><br>
    <input type="text" id="direccion" disabled value="<%=direccion%>">
    <label id="ltel">Telefono</label><br>
    <input type="text" id="telefono" disabled value="<%=telefono%>">
    <label id="lciu">Ciudad</label><br>
    <input type="text" id="ciudad" disabled value="<%=ciudad%>">
    <button onclick="cargarCliente();" id="buttonCliente" class="button"> Cargar Datos </button>
    <div id="mensajeCreacion"></div>
    </form>
    

    <% 
        //captura de datos sobre la factura digitada, para que no se pierdan
        String idFactura = request.getParameter("idFactura");
        String fechaRealizacion = request.getParameter("fechaRealizacion");
        String fechaVencimiento = request.getParameter("fechaVencimiento");
        String ordenCompra = request.getParameter("ordenCompra");
        String remision =  request.getParameter("remision");
        
        //validacion en caso que aun no se haya digitado ninguna factura, deja los campos en blanco.
        if(idFactura == null){
        idFactura="";
        fechaRealizacion="";
        fechaVencimiento="";
        ordenCompra="";
        remision="";
        }

    %>
    <form action="SvItem" method="GET">

    <div id="bloquefactura1">
    <div class="labelform2">
    <label id="lfactura">ID factura</label>
    <label id="lfecrel">Fecha de realizacion</label>
    <label id="lfecven">Fecha de vencimiento</label>
    <label id="lorcom">Orden de compra</label>
    <label id="lrem">Remision</label>
    </div>

    <div class="form2">
    <input type="text" id="" class="filainput1" name="idFactura" value="<%=idFactura%>">     
    <input type="text" id="" class="filainput1" name="fechaRealizacion" placeholder="aaaa-mm-dd" value="<%=fechaRealizacion%>">
    <input type="text" id="" class="filainput1" name="fechaVencimiento" placeholder="aaaa-mm-dd" value="<%=fechaVencimiento%>">
    <input type="text" id="" class="filainput1" name="ordenCompra" value="<%=ordenCompra%>">
    <input type="text" id="" class="filainput1" name="remision" value="<%=remision%>">
    <%-- input tipo hidden para capturar los datos y volverlos a pasar a traves de la URL, asi no se van a perder --%>
    <input name="idCliente" type="hidden" value="<%=idCliente%>"/>
    <input name="nombre" type="hidden" value="<%=nombre%>"/>
    <input name="direccion" type="hidden" value="<%=direccion%>"/>
    <input name="telefono" type="hidden" value="<%=telefono%>"/>
    <input name="ciudad" type="hidden" value="<%=ciudad%>"/>
    </div>
    </div>
    <div id="bloquefactura2">
    <h2 id="titulo2">Items de la factura</h2>
    <div class="labelform3">
    <label id="lcod">Codigo</label>
    <label id="ldesc">Descripcion</label>
    <label id="lcant">Cantidad</label>
    <label id="lvalun">Valor unitario</label>
    </div>

    <div class="form3">
    <input type="text" id="" class="filainput1" name="codigoItem">     
    <input type="text" id="" class="filainput1" name="descripcionItem">
    <input type="text" id="" class="filainput1" name="cantidadItem">
    <input type="text" id="" class="filainput1" name="valorItem">
    </div>
    </div>
    <button onclick="addItem();" id="buttonItem" class="button"> Agregar Item</button><br>
    </form>
    
    <hr id="barra1" width="100%" size="5">
    <% //idFactura = "5";
        String iva = request.getParameter("iva");
        String retefuente = request.getParameter("retefuente");
        String total = request.getParameter("total");
        String visibility="visibility: visible;";

        
        if(iva == null){
        iva = "";
        retefuente = "";
        total = "";
        //visibilidad del boton de generar y enviar factura, si ya se guardo antes.
        visibility="visibility: hidden;";
        }
        
    %>
    <form action="SvFactura" method="POST">


    <label id="lobserv">Observaciones </label>
    <textarea name="observaciones" id="observ" rows="6" cols="80"></textarea>
    <div class="labelform4">
    <label id="">IVA</label><BR>
    <label id="">RETEFUENTE</label><BR>
    <label id="">TOTAL</label><BR>
    </div>

    <div class="form4">
    <input type="text" name="iva" class="filainput1" disabled value="<%=iva%>"><br>     
    <input type="text" name="retefuente" class="filainput1" disabled value="<%=retefuente%>"><br>
    <input type="text" name="total" class="filainput1" disabled value="<%=total%>"><br>
    <input name="idFactura" type="hidden" value="<%=idFactura%>"/>
    </div>
    <button onclick="generar();" id="buttonGuardar" class="button">Generar</button><br>
    </form>

    <form>
    <button onclick="enviar();" id="buttonEnviar" class="button" style="<%=visibility%>">Enviar factura</button><br>
    </form>
    </body>
</html>
