<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Conta</title>
</head>
<body>
	<form action="control?" method="post">
		<select name="idcliente">
			<%	
			List<Cliente> listapf = new ClienteDAO().listarPF();
			//List<Cliente> listapj = new ClienteDAO().listarPJ();
			
			for(Cliente cliente : listapf){
				out.println("<option value'" + cliente.idcliente + "'>" + cliente.getNome() + " - " + cliente.getCpf() + "</option>");
			}
			//for(Cliente cliente : listapj){
				//out.println("<option value'" + cliente.idcliente + "'>" + cliente.getNome() + " - " + cliente.getCnpj() + "</option>");
			//}
			
			%>
		
		</select>
		<input type="submit" value="Cadastrar">		
		

	
	</form>
</body>
</html>