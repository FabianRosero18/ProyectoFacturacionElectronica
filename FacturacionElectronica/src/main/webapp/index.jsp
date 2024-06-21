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
        <title>JSP Page</title>
    </head>
  <body>

  <link rel="stylesheet" type="text/css" href="css/loggin.css">

    <img src="images/logo.jpg" /><br>
    
    <h1>Iniciar sesion</h1><br>
    <% String mensaje = request.getParameter("mensajeError");
        if(mensaje == null){
            mensaje="";
        }
    
    %>
    
    <form action="SvCliente" method="POST">
    <div class="form">
    <label>Usuario</label><br>
    <input type="text" id="user" name="usuario"><br>
    <label>Contraseña</label><br>
    <input type="password" id="pass" name="contraseña"><br>
    <div id="verificacion"><p><%=mensaje%></p></div>
    <button onclick="" class="button"> Inicio </button><br>
    </div>
    </form>
    
  </body>
</html>
