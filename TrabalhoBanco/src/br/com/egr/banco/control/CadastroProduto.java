package br.com.egr.banco.control;

import java.io.IOException;
import java.util.Random;

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
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;
import br.com.egr.banco.model.Produto;
import br.com.egr.banco.model.Seguro;


public class CadastroProduto implements Servidor{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	try {
		
		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
		String tipoProduto = req.getParameter("produto");
		
		
		// Gera um numero aleatorio que será usado para a conta.
		Random random = new Random();
		int numero = random.nextInt(1000);
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		PessoaFisica pf = new PessoaFisica();
		
		String tipo = "";
		Cliente cliente = null;
		
		
		if(pfDAO.pesquisarId(idcliente) != null) {
			cliente = new PessoaFisicaDAO().pesquisarId(idcliente);
			System.out.println("\n \n Cliente: " + cliente.getNome());
			
		}
		else if(pjDAO.pesquisarId(idcliente) != null) {
			cliente = new PessoaJuridicaDAO().pesquisarId(idcliente);
		}
		
		
		
		String classeNome = "br.com.egr.banco.model." + tipoProduto;
		Class<?> produto = Class.forName(classeNome);
		Produto prod = (Produto) produto.getDeclaredConstructor().newInstance();
		
		Conta conta = null;
		Seguro seguro = null;
		
		
		if (prod instanceof Conta) {
			conta = (Conta) prod;
			conta.setNumero(numero);
			conta.ativar();
			if(conta instanceof ContaCorrente) {cliente.addCCorrente(conta.getNumero());}
			else if(conta instanceof ContaPoupanca) {cliente.addCPoupanca(conta.getNumero());}
			
			ContaDAO contaDAO = new ContaDAO();
			contaDAO.inserir(conta, tipoProduto, cliente);
			
			
		} else if (prod instanceof Seguro) {
			int valorSeguro = Integer.parseInt(req.getParameter("valorSeguro"));
			seguro = (Seguro) prod;
			seguro.setNumero(numero);
			seguro.setValor(valorSeguro);
			
			SeguroDAO seguroDAO = new SeguroDAO();
			seguroDAO.inserir(seguro, cliente);
		}
		
			
		return "index.jsp";
	} catch (Exception e) {
		throw new ServletException(e);
	}
	}
}
