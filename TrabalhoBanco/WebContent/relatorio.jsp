<%@page import="br.com.egr.banco.dao.ContaDAO"%>
<%@page import="br.com.egr.banco.dao.PessoaFisicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaFisica"%>
<%@page import="br.com.egr.banco.dao.PessoaJuridicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaJuridica"%>
<%@page import="br.com.egr.banco.model.Cliente"%>
<%@page import="br.com.egr.banco.model.Conta"%>
<%@page import="br.com.egr.banco.model.Seguro"%>
<%@page import="br.com.egr.banco.model.Produto"%>
<%@page import="br.com.egr.banco.model.Relatorio"%>
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
		
		Relatorio rl = new Relatorio();
		Double imposto = rl.calcularImposto(c);
	
		out.println("<p> Cliente: " + c.getNome()+ "</p>");
		
	%>
	
	<table border="1">
		<tr>
			<th>Numero</th>
			<th>Saldo/Valor</th>
			<th>Situacao</th>
			<th>Tipo</th>
		</tr>
		<% 
		List<Conta> contas = (List<Conta>) request.getAttribute("lista");
		List<Seguro> seguros = (List<Seguro>) request.getAttribute("seguro");
		
		for(Conta ct : contas){
			out.println("<tr>");
			out.println("<td>" + ct.getNumero() + "</td>");
			out.println("<td>" + ct.getSaldo() + "</td>");
			out.println("<td>" + ct.getSituacao() + "</td>");
			out.println("<td>" + ct.getClass().getSimpleName() + "</td>");
			out.println("</tr>");
		}
		for(Seguro s: seguros){
			out.println("<tr>");
			out.println("<td>" + s.getNumero() +"</td>");
			out.println("<td>" + s.getValor() +"</td>");
			out.println("<td>" + s.getSituacao() + "</td>");
			out.println("<td>" + s.getClass().getSimpleName() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<h4>Valor do Imposto: <%=imposto%></h4>
		
</body>
</html>