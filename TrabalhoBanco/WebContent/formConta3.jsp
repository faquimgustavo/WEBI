<%@page import="br.com.egr.banco.dao.PessoaFisicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaFisica"%>
<%@page import="br.com.egr.banco.dao.PessoaJuridicaDAO"%>
<%@page import="br.com.egr.banco.model.PessoaJuridica"%>
<%@page import="br.com.egr.banco.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir Conta</title>
</head>
<body>
	<h4>Cadastro de Conta</h4><br>
	
	<form action="control?x=CadastroConta" method="post">
		<p>Selecione o cliente...</p>
		<h5>Clientes Fisicos</h5>
		<%
			List<PessoaFisica> listapf = new PessoaFisicaDAO().listarPF();
		
			for(PessoaFisica pf : listapf){
				%>	
			
			<input type='radio' name="cliente" value='<%=pf.getIdcliente()%>' > Nome: <%=pf.getNome()%> CPF: <%=pf.getCpf()%>)<br>
			<% }%>
			
			
			<h5>Clientes Juridicos</h5>
			<%
			List<PessoaJuridica> listapj = new PessoaJuridicaDAO().listarPJ();
			for(PessoaJuridica pj : listapj){
				%>		
			<input type='radio' name="cliente" value='<%=pj.getIdcliente()%>' > Nome: <%=pj.getNome()%> CNPJ: <%=pj.getCnpj()%>)<br>
			<% }%>
			<br><br><br>
			<input type="submit" value="Cadastrar Conta">
	</form>
</body>
</html>