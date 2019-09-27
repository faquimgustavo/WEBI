package br.com.egr.banco.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.dao.ContaDAO;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.dao.PessoaJuridicaDAO;
import br.com.egr.banco.dao.SeguroDAO;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.Conta;
import br.com.egr.banco.model.Produto;
import br.com.egr.banco.model.Relatorio;
import br.com.egr.banco.model.Seguro;

public class GeraRelatorio implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
	
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		Cliente cliente = null;
		
		if(pfDAO.pesquisarId(idcliente) != null) {
			cliente = new PessoaFisicaDAO().pesquisarId(idcliente);
			
		}
		else if(pjDAO.pesquisarId(idcliente) != null) {
			cliente = new PessoaJuridicaDAO().pesquisarId(idcliente);
		}
		
		List<Conta> lista = new ContaDAO().pesquisarConta(idcliente);
		List<Seguro> seguro = new SeguroDAO().pesquisarSeguro(idcliente);
		
		
		Relatorio rl = new Relatorio();
		rl.calcularImposto(cliente);
		
		
		req.setAttribute("lista", lista);
		req.setAttribute("cliente", cliente);
		req.setAttribute("imposto", rl);
		req.setAttribute("seguro", seguro);


		
		
		return "relatorio.jsp";
	}

}
