package br.com.egr.banco.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.dao.ClienteDAO;
import br.com.egr.banco.dao.ContaDAO;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.dao.PessoaJuridicaDAO;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.Conta;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;

public class ListaConta implements Servidor {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
		
		List<Conta> lista = new ContaDAO().pesquisarConta(idcliente);
		
		req.setAttribute("lista", lista);
	
		return "operacao2.jsp";
	}

}
