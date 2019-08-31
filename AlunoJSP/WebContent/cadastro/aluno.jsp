<%@page import="java.util.List"%>
<%@page import="br.com.gustavofaquim.alunojsp.model.Cidade"%>
<%@page import="br.com.gustavofaquim.alunojsp.dao.CidadeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../alunoCadastro">
		Nome: <input type="text" name="nome"><br><br>
		Idade: <input type="number" name="idade"><br><br>
		Cidade <select name="idCidade">
			   		<% 
			   		List<Cidade> lista = new CidadeDAO().listar();
			   		for (Cidade c: lista){
			   			out.println("<option value='" + c.getId() + "'>" + c.getNome() + " - " + c.getEstado() + "</option>");
			   		}
			   	
			   		%>
			   </select><br><br>
		<input type="submit" value="Gravar">
	</form>
</body>
</html>