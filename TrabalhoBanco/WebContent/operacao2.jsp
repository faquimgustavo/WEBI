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
<title>Insert title here</title>
</head>
<body>
		<h4>Contas</h4>
		<select name="idconta">
		<%	
		List<Conta> listaConta = new ContaDAO().listarTudo();
			 
			out.println("<optgroup label='Contas do Cliente'>");
			for(Conta ct : listaConta){
				out.println("'> Numero: " + ct.getNumero() + " - Saldo: " + ct.getSaldo() + "<br> </option>");
			}
			
			%>
		
		</select><br><br>
	
		
		<h4>Adicionar produto</h4>
		<input type="radio" name="produto" value="ContaCorrente"> Saque <br><br>
  		<input type="radio" name="produto" value="ContaPoupanca"> Deposito <br><br>
  		<br> Valor<br> 
  		R$ <input type="number" name="valorOperacao" value="5000"><br><br>  
		
		<br><br>
		

</body>
</html>