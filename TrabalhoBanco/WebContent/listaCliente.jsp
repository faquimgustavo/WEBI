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
			<%
				List<Cliente> clientes = (List<Cliente>) request.getAttribute("lista");
				List<PessoaFisica> pfs = (List<PessoaFisica>) request.getAttribute("listapf");
			
				for(PessoaFisica pf : pfs){
					out.println("id: " + pf.getIdcliente() + "| Nome: " + pf.getNome() +"<br>Telefone: "  + pf.getTelefone() +"<br>CPF: " + pf.getCpf());
					out.println("<br>Produtos: <br>" + pf.getProdutos().size());
			%>
			<%		
				}
			%>

</body>
</html>