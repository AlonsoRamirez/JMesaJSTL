<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="modelo.*,java.util.*, javabeans.*" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar ventas</title>
</head>
<jsp:useBean id="mensa" scope="request" class="javabeans.VentasBean" />
       <jsp:setProperty name="mensa" property="*" /> 
      
        <%
            if(request.getParameter("descripcion") != null ){
        %>
        <jsp:forward page="Controlador?operacion=grabar"/>
        <%
            }          
        %>
        <body>
            <center>
                <h1>Generación de ventas</h1>
                <form method="post">
                    <br><br>
                    <b>Datos de la venta:</b><br/><br/>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/inventario"
     user="root"  password=""/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * from lineas_de_venta;
</sql:query>
 
<select name="id_linea">
<c:forEach var="row" items="${result.rows}">
<option value="${row.id_linea}">
${row.linea}
</option>
</c:forEach>
</select>
              <br/><br/>
                    Introduzca fecha: <input type="text" name="fecha"><br/>
                    <br/>
                    Introduzca descripción: <textarea name="descripcion" id="descripcion"></textarea><br/>
                    <hr><br/>
                    <input type="submit" name="submit" value="Enviar">
                    <input type="reset" value="Reset">
                </form>
            </center>
        </body>

</html>