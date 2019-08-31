<%@page import="java.util.List"%>
<%@page import="br.com.gustavofaquim.alunojsp.model.Aluno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Lista de alunos</h3>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Idade</th>
			<th>Cidade</th>
			<th>Excluir</th>
		</tr>
		
		<% 
			List<Aluno> alunos = (List<Aluno>) request.getAttribute("lista");
			for(Aluno a : alunos){%>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getNome()%></td>
				<td><%=a.getIdade() %></td>
				<td><%=a.getCidade().getNome()%></td>
				<td><a href="sss"></td>
			</tr>
			<% } %>
		
	</table>
</body>
</html>