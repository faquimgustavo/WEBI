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
<title>Cadastro Conta</title>
</head>
<body>
	<form action="control?x=CadastroProduto" method="post">
		<h4>Clientes</h4>
		<select name="idcliente">
			<%	
			List<PessoaFisica> listapf = new PessoaFisicaDAO().listarPF();
			 
			out.println("<optgroup label='Clientes Físicos'>");
			for(PessoaFisica pf : listapf){
				out.println("<option value='" +  pf.getIdcliente() + "'> Nome: " + pf.getNome() + " - CPF: " + pf.getCpf() + "<br> </option>");
			}
			out.println("<optgroup label='Clientes Jurídicos'>");
			List<PessoaJuridica> listapj = new PessoaJuridicaDAO().listarPJ();
			out.println("Clientes Juridicos");
			for(PessoaJuridica pj : listapj){
				out.println("<option value='" +  pj.getIdcliente() + "'> Nome: " + pj.getNome() + " - CNPJ: " + pj.getCnpj() + "<br> </option>");
			}
			%>
		</select><br><br>
	
		
		<h4>Adicionar produto</h4>
		<input type="radio" name="produto" value="ContaCorrente"> Conta Corrente <br><br>
  		<input type="radio" name="produto" value="ContaPoupanca"> Conta Poupança <br><br>
  		<input type="radio" name="produto" value="Seguro"> Seguro <br><br> Valor do Seguro<br> 
  		R$ <input type="number" name="valorSeguro" value="5000"><br><br>  
		
		<br><br>
		
		<input type="submit" value="Cadastrar">		
	</form>
	
</body>
</html>