package br.com.egr.banco.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.model.PessoaFisica;

public class CadastroCliente implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		String endereco = req.getParameter("endereco");
		String cpf = req.getParameter("cpf");
		String x = req.getParameter("x");
		String tipo = req.getParameter("tipo");
		
		PessoaFisica pf = new PessoaFisica(nome,telefone,endereco, cpf);
		System.out.println(tipo);
		
		
		
		return null;
	}

}
