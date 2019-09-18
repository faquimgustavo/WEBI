<%@page import="br.com.egr.banco.dao.PessoaFisicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaFisica"%>
<%@page import="br.com.egr.banco.dao.PessoaJuridicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaJuridica"%>
<%@page import="br.com.egr.banco.model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="br.com.egr.banco.dao.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Cliente</title>
</head>
<body>
	<h4>Lista de Clientes</h4>
	<br><br><h5>Pessoas Físicas</h5>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Endereco</th>
				<th>CPF</th>
				<th>Produtos</th>
			</tr>
			<%
			
				List<Cliente> clientes = (List<Cliente>) request.getAttribute("lista");
				List<PessoaFisica> pfs = (List<PessoaFisica>) request.getAttribute("listapf");
			
				for(PessoaFisica pf : pfs){	
			%>
			<tr>
				<td><%=pf.getIdcliente()%></td>
				<td><%=pf.getNome()%></td>
				<td><%=pf.getTelefone()%></td>
				<td><%=pf.getEndereco()%></td>
				<td><%=pf.getCpf()%></td>
				<td><%=pf.getProdutos()%></td>
				
			</tr>
			
			<%		
				}
			%>
			
			
		</table>
</body>
</html>