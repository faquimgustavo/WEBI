<%@page import="java.util.List"%>
<%@page import="br.com.gustavofaquim.alunojsp.model.Cidade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Lista das cidades</h3>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Estado</td>
		</tr>
		
		<% 
		List<Cidade> cidades = (List<Cidade>) request.getAttribute("lista");
		for(Cidade c : cidades){
			out.println("<tr>");
			out.println("td" + c.getId() + "</td>");
			out.println("<td>" + c.getNome() + "</td>");
			out.println("<td>" + c.getEstado() + "</td>");
		}
		%>
	</table>
</body>
</html>