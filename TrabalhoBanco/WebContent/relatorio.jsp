<%@page import="br.com.egr.banco.dao.ContaDAO"%>
<%@page import="br.com.egr.banco.dao.PessoaFisicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaFisica"%>
<%@page import="br.com.egr.banco.dao.PessoaJuridicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaJuridica"%>
<%@page import="br.com.egr.banco.model.Cliente"%>
<%@page import="br.com.egr.banco.model.Conta"%>
<%@page import="java.util.List"%>
<%@page import="br.com.egr.banco.dao.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório</title>
</head>
<body>
	<h3>Relatório</h3><br><br>
	<%
		String tipoCliente = request.getAttribute("cliente").getClass().getSimpleName();
		
		String classeNome = "br.com.egr.banco.model." + tipoCliente;
		Class<?> produto = Class.forName(classeNome);
		Cliente c = (Cliente) produto.getDeclaredConstructor().newInstance();
		
		c = (Cliente) request.getAttribute("cliente");
	
		out.println("<p> Cliente: " + c.getNome()+ "</p>");
	%>
	
		
</body>
</html>