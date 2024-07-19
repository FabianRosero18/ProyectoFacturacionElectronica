<%-- 
    Document   : index
    Created on : 19/06/2024, 4:44:06 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loggin</title>
    </head>
  <body>

  <link rel="stylesheet" type="text/css" href="css/loggin.css">

    <img src="images/logo.jpg" /><br>
    
    <h1>Iniciar sesion</h1><br>
    <% //validaciones para determinar si mostrar el menu de opciones o mensaje de fallo de inicio
        String mensaje = request.getParameter("mensajeError");
       String visibBoton =  request.getParameter("visibBoton");
       String visibMenu = request.getParameter("visibMenu");
       boolean failed = Boolean.parseBoolean(request.getParameter("fallido"));

       
        if(mensaje == null){
            mensaje="";
            visibBoton="visible";
            visibMenu="hidden";
            failed = false;
        }
    %>

    <form action="SvLoggin" method="GET">
        <div class="form">

        <label>Usuario</label><br>
        <input type="text" id="user" name="usuario"><br>
        <label>Contraseña</label><br>
        <input type="password" id="pass" name="contraseña"><br>
        <div id="verificacion"><p><%=mensaje%></p></div>
        <button onclick="" class="button" style="visibility:<%=visibBoton%>"> Ingresar </button><br><br>
        <script>
        <% if(failed == true) %> window.alert("usuario o contraseña incorrecto");
        </script>   
            </div>

    </form>
        <div class="form">
    <form action="SvMenu" method="GET" style="visibility:<%=visibMenu%>">
        
        <input name="seleccion" id="seleccion" type="hidden" value=""/>
        <!<!-- los botones tienen funciones javascript para redirigir con el servlet al modulo seleccionado -->
        <button class="button" onclick="javascript:document.getElementById('seleccion').value = 'FacturaElectronic.jsp'"> Crear Factura </button><br><br>
        <button class="button" onclick="javascript:document.getElementById('seleccion').value = 'CreacionCliente.jsp'"> Crear Cliente </button>

    </form>
    </div>
  </body>
</html>
