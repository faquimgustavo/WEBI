<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Juridico</title>
</head>
<body>
	<form action="control?x=CadastrarCliente&tipo=PessoaJuridica" method="post">
		Nome: <br><input type="text"><br><br>
		Telefone: <br><input type="text"><br><br><br>
		Endereco: <br><input type="text"><br><br>
		Nome Fantasia: <br><input type="text"><br><br>
		CNPJ: <br><input type="text"><br><br>
		
		<input type="submit" value="Salvar">
	</form>
</body>
</html>