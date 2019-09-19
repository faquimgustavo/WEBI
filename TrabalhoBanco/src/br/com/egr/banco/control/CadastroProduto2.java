package br.com.egr.banco.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import br.com.egr.banco.dao.ClienteProdutoDAO;
import br.com.egr.banco.dao.ContaDAO;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.dao.PessoaJuridicaDAO;
import br.com.egr.banco.dao.SeguroDAO;
import br.com.egr.banco.model.ContaCorrente;
import br.com.egr.banco.model.ContaPoupanca;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;
import br.com.egr.banco.model.Seguro;

public class CadastroProduto2 implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
		String produto = req.getParameter("produto");
		
		// Gera um numero aleatorio que será usado para a conta.
		Random random = new Random();
		int numero = random.nextInt(1000);
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		PessoaJuridica pj = new PessoaJuridica();
		PessoaFisica pf = new PessoaFisica();
		
		// Verifica se o idcliente passando pela URL é de uma pessoa juridica;
		if(pjDAO.verifica(idcliente)) {
			if(produto.equals("contaCorrente")) {
				pj.addCCorrente(numero);
			}
			else if(produto.equals("contaPoupanca")) {
				pj.addCPoupanca(numero);
			}
			else if(produto.equals("Seguro")) {
				Double valorSeguro = Double.parseDouble(req.getParameter("valorSeguro"));
				pj.addSeguro(numero, valorSeguro);
			}
		}
		// Verifica se o idcliente passado pela URL é de uma pessa fisica.
		else if(pfDAO.verifica(idcliente)) {
			if(produto.equals("contaCorrente")) {
				System.out.println("\n \n \n"+ numero +"\n \n \n");
				//metodo addCCorrente não funciona
				pf.addCCorrente(numero);
			}
			else if(produto.equals("contaPoupanca")) {
				pf.addCPoupanca(numero);
			}
			else if(produto.equals("Seguro")) {
				Double valorSeguro = Double.parseDouble(req.getParameter("valorSeguro"));
				pf.addSeguro(numero, valorSeguro);
			}
		}
		
		if(produto.equals("contaCorrente")) {
			Double valorConta = Double.parseDouble(req.getParameter("valorCorrente"));
			
			ContaCorrente cc = new ContaCorrente(numero);
			cc.depositar(valorConta);
			cc.ativar();
			
			
			String tipo = "Conta Corrente";
			ContaDAO contaDAO = new ContaDAO(); 
			contaDAO.inserir(cc, tipo);
			
			ClienteProdutoDAO cpDAO = new ClienteProdutoDAO();
			cpDAO.inserirConta(idcliente, cc);
		}
		
		else if(produto.equals("contaPoupanca")) {
			Double valorConta = Double.parseDouble(req.getParameter("valorPoupanca"));
			
			ContaPoupanca cp = new ContaPoupanca(numero);
			cp.depositar(valorConta);
			cp.ativar();
			
			String tipo = "Conta Poupanca";
			
			ContaDAO contaDAO = new ContaDAO(); 
			contaDAO.inserir(cp, tipo);
		}
		
		else if(produto.equals("Seguro")) {
			Double valorSeguro = Double.parseDouble(req.getParameter("valorSeguro"));
			Seguro seguro = new Seguro(numero, valorSeguro);
			
			SeguroDAO seguroDAO = new SeguroDAO();
			seguroDAO.inserir(seguro);
		}
		return "index.jsp";
	}

}
