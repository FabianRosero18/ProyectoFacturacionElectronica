<%-- 
    Document   : CreacionCliente
    Created on : 19/07/2024, 8:36:40 a. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso de clientes</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="css/crear_cliente.css">
        <script src="js/crear_cliente.js"></script>

        <img src="images/logo.jpg" /><br>

        <h1>Ingreso de clientes</h1><br><br><br>

        <div>
            <form action="SvCliente" method="POST">
                <label class="textcolumn1">ID</label><br>
                <input type="text" class="column1" name="idCliente"><br><br>
                <label class="textcolumn1">Tipo</label><br>
                <input type="text" id="tipo" class="column1" name="tipoId"><br><br>
                <label class="textcolumn1">Nombre</label><br>
                <input type="text" id="nombre" class="column1" name="nombre"><br><br>
                <label class="textcolumn1">Direccion</label><br>
                <input type="text" id="direccion" class="column1" name="direccion"><br><br>
                <label class="textcolumn1">Telefono</label><br>
                <input type="text" id="telefono" class="column1" name="telefono"><br><br>
                <div id="mensajeCreacion"></div>
                <label class="textcolumn2">Matricula Mercantil</label><br>
                <input type="text" id="matMer" class="column2" name="matriculaMercantil"><br><br>
                <label class="textcolumn2">Responsabil. Financieras</label><br>
                <input type="text" id="resFin" class="column2" name="responsFinancieras"><br><br>
                <label class="textcolumn2">Forma de pago</label><br>
                <input type="text" id="formPag" class="column2" name="formaPago"><br><br>
                <label class="textcolumn2">Correo para FE</label><br>
                <input type="text" id="correoFe" class="column2" name="correoFe"><br><br>
                <input name="ciudad" type="hidden" value="Cali"/>
                <input name="factura" id="factura" type="hidden" value=""/>

                <button onclick="crearCliente();" class="button"> Crear Cliente </button><br>
                <button onclick="javascript:document.getElementById('factura').value = 'factura'" class="button" style="position: absolute;
                                                                        left: 1300px;
                                                                        top:  800px; "> Modulo de facturas </button><br>

            </form>
        </div>
    </body>
</html>
