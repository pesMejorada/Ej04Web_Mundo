<%@page import="es.mundo.modelo.Pais"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Individual</title>
</head>
<body>
<form action="Procesar" method="get">
<% Pais pais = (Pais)request.getAttribute("pais"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
      <th>Habitantes</th> 
    </tr>
   <tr>
      <td><input type="text" name="id" value="<%=pais.getId() %>" readonly="readonly"/></td>
      <td><input type="text" name="nombre" value="<%=pais.getNombre() %>"/></td>
      <td><input type="text" name="habitantes" value="<%=pais.getHabitantes() %>"/></td>
  </tr>
</table>
 <input type="submit" value="Borrar" id="borrar"/>
</form>
</body>
</html>