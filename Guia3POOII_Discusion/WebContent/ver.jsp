<%@page import="javabeans.*,java.util.*" %>
<%@ taglib uri="/WEB-INF/tld/jmesa.tld" prefix="jmesa" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar ventas</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jmesa.css"></link>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.bgiframe.pack.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.jmesa.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jmesa.js"></script>
		<script>
			function onInvokeAction(id) { 
				setExportToLimit(id, '');
				createHiddenInputFieldsForLimitAndSubmit(id);
			}
			function onInvokeExportAction(id) {
				var parameterString = createParameterStringForLimit(id); 
				location.href = document.pages.selectIndex.value + parameterString;
			}	
		</script>

</head>
<body>

                <%
                   ArrayList mensajes=(ArrayList)request.getAttribute("mensajes");
                   if(mensajes != null){
                        for(int i=0;i<mensajes.size();i++){
                            VentasBean m=(VentasBean)mensajes.get(i);
                            if(mensajes.size()!=0){
                            
               
                            }
                        }
                   }
                   
                %>
                
                      <form name="mensajesForm" action="${pageContext.request.contextPath}/Controlador"> 
	  <input type="hidden" name="operacion" value="ver" />
	
	   
    <jmesa:tableModel
        id="tag" 
        items="${mensajes}"
        var="bean" >
        <jmesa:htmlTable>               
            <jmesa:htmlRow>     
                <jmesa:htmlColumn property="id_venta" title="ID Venta" />
                <jmesa:htmlColumn property="id_linea" title="ID Linea" />
                <jmesa:htmlColumn property="fecha" title="Fecha" />
                <jmesa:htmlColumn property="descripcion" title="Descripcion" />
               <jmesa:htmlColumn property="venta" titleKey="Eliminar">
    <a href="Controlador?operacion=eliminar&id=${bean.id_venta}">Eliminar</a>
</jmesa:htmlColumn>
            </jmesa:htmlRow>
        </jmesa:htmlTable> 
    </jmesa:tableModel>

</form>
            <br>
            <br>
            <a href="inicio.html">Inicio</a>
                


</body>
</html>