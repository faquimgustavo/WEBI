package br.com.egr.banco.control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.dao.PessoaJuridicaDAO;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;

public class CadastroProduto implements Servidor{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
		String produto = req.getParameter("produto");
		
		// Gera um numero aleatorio que será usado para a conta.
		Random random = new Random();
		int numero = random.nextInt(1000);
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		Cliente c = new PessoaJuridica();
		
		if(pjDAO.verifica(idcliente)) {
			c = pjDAO.pesquisarId(idcliente);
		}
		
		else if(pfDAO.verifica(idcliente)) {
			c = pfDAO.pesquisarId(idcliente);	
		}
		
		if(produto.equals("ContaPoupanca")) {
			
		}
		
		return "index.jsp";
	}
	
}
