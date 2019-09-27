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
<title>Operações</title>
</head>
<body>
		<%
		
		String tipoCliente = request.getAttribute("cliente").getClass().getSimpleName();
		
		String classeNome = "br.com.egr.banco.model." + tipoCliente;
		Class<?> produto = Class.forName(classeNome);
		Cliente c = (Cliente) produto.getDeclaredConstructor().newInstance();
		
		c = (Cliente) request.getAttribute("cliente");
	
		out.println("<h2> Cliente: " + c.getNome()+ "</h2>");
		
		%>
		
		<br><h4>Dados da Conta</h4>
		
		<form action="control?x=Operacao" method="post">	
		<select name="idconta">
		<%	
			//List<Conta> listaConta = new ContaDAO().listarTudo();
			List<Conta> contas = (List<Conta>) request.getAttribute("lista");
			
			out.println("<optgroup label='Contas do Cliente'>");
			for(Conta ct : contas){
				out.println("<option value='" + ct.getNumero() + "'> Numero: " + ct.getNumero() + " - Saldo: " + ct.getSaldo() + "<br> </option>");
			}
			
			%>
		
		</select><br><br>
		
		<h4>Operação</h4>
		<input type="radio" name="produto" value="saque"> Saque <br><br>
  		<input type="radio" name="produto" value="deposito"> Deposito <br><br>
  		<br>
  		<input type="radio" name="produto" value="transferencia"> Transferência <br>
  		<p>Conta de destino</p>
  		<select name="idconta2">
		<%	
			List<Conta> listaConta = (List<Conta>) request.getAttribute("listarContas");
						
			out.println("<optgroup label='Contas do Cliente'>");
			for(Conta ct : listaConta){
				out.println("<option value='" + ct.getNumero() + "'> Numero: " + ct.getNumero() + " - Saldo: " + ct.getSaldo() + "<br> </option>");
			}
			
		%>
		</select><br><br>
  		<br> Valor<br> 
  		R$ <input type="number" name="valorOperacao" value="5000"><br><br>  
		<br>
		<input type="submit" value="Realizar Operação">
		</form>

</body>
</html>