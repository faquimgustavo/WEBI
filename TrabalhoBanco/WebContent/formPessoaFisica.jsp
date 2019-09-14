<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Pessoa</title>
</head>
<body>
	<form action="control?x=CadastrarCliente&tipo=PessoaFisica" method="post">
		Nome: <br><input type="text"><br><br>
		Telefone: <br><input type="text"><br><br><br>
		Endereco: <br><input type="text"><br><br>
		CPF: <br><input type="text"><br><br>
		Nome Mãe: <br><input type="text"><br><br>
		Nome Pai: <br><input type="text"><br><br>
		
		<input type="submit" value="Salvar">
	</form>
</body>
</html>