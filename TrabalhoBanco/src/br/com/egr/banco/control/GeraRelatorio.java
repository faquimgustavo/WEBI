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
import br.com.egr.banco.model.ContaCorrente;
import br.com.egr.banco.model.ContaPoupanca;
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
		double imposto = 0;
		
		for(Conta c : lista) {
			if (c instanceof ContaCorrente) {
				cliente.addCCorrente(c.getNumero());
				imposto += rl.calcularImposto(c);
			}
			else if(c instanceof ContaPoupanca) {
				cliente.addCPoupanca(c.getNumero()); 
			    imposto += rl.calcularImposto(c);
			}
		}
		for(Seguro s: seguro) {
			cliente.addSeguro(s.getNumero(), s.getValor());
			imposto += rl.calcularImposto(s);
		}
		
		
		
		//Relatorio rl = new Relatorio();
		//Double imposto = rl.calcularImposto(cliente);
		
		System.out.println("Imposto : " + imposto);
		
		
		req.setAttribute("lista", lista);
		req.setAttribute("cliente", cliente);
		req.setAttribute("imposto", imposto);
		req.setAttribute("seguro", seguro);

		return "relatorio.jsp";
	}

}
