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
<title>Cadastro Produto</title>
</head>
<body>
	<h3>Cadastro de Produtos</h3>
	<a href="formConta.jsp?tipo=ContaCorrente">Conta Corrente</a><br><br>
	<a href="formConta.jsp?tipo=ContaPoupanca">Conta Poupança</a><br><br>
	<a href="formSeguro?tipo=Seguro">Seguro</a><br>
</body>
</html>