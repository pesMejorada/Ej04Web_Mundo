<%@page import="java.util.ArrayList"%>
<%@page import="es.mundo.modelo.Pais"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
</head>
<body>
<% ArrayList<Pais> paises = (ArrayList<Pais> )request.getAttribute("listado"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Nombre</th>
      <th>Habitantes</th> 
    </tr>
  <% for(Pais pais: paises){ %>  
   <tr>
      <td><%=pais.getId() %></td>
      <td><%=pais.getNombre() %></td>
      <td><%=pais.getHabitantes() %></td>
  </tr>
  <%}// del for %>
</table>
  <p><a href="index.html"  >Ir a Inicio</a></p>
</body>
</html>