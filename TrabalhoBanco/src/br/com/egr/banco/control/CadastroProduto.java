package br.com.egr.banco.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import br.com.egr.banco.dao.ClienteProdutoDAO;
import br.com.egr.banco.dao.ContaDAO;
import br.com.egr.banco.dao.SeguroDAO;
import br.com.egr.banco.model.Conta;
import br.com.egr.banco.model.ContaCorrente;
import br.com.egr.banco.model.ContaPoupanca;
import br.com.egr.banco.model.Seguro;

public class CadastroProduto implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
		String produto = req.getParameter("produto");
		System.out.println(" \n \n \n Aqui jfjdjdfhdjfhdjfhdjfhdjfdjfdhjh");
		if(produto.equals("contaCorrente")) {
			Double valorConta = Double.parseDouble(req.getParameter("valorCorrente"));
			
			// Gera um numero aleatorio que será usado para a conta.
			Random random = new Random();
			int numero = random.nextInt(1000);
			
			
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
			
			// Gera um numero aleatorio que será usado para a conta.
			Random random = new Random();
			int numero = random.nextInt(1000);
			
			ContaPoupanca cp = new ContaPoupanca(numero);
			cp.depositar(valorConta);
			cp.ativar();
			
			String tipo = "Conta Poupanca";
			
			ContaDAO contaDAO = new ContaDAO(); 
			contaDAO.inserir(cp, tipo);
			
			ClienteProdutoDAO cpDAO = new ClienteProdutoDAO();
			cpDAO.inserirConta(idcliente, cp);
		}
		
		else if(produto.equals("Seguro")) {
			Double valorSeguro = Double.parseDouble(req.getParameter("valorSeguro"));
			
			Random random = new Random();
			int numero = random.nextInt(1000);
			
			Seguro seguro = new Seguro(numero, valorSeguro);
			
			SeguroDAO seguroDAO = new SeguroDAO();
			seguroDAO.inserir(seguro);
			
			ClienteProdutoDAO cpDAO = new ClienteProdutoDAO();
			cpDAO.inserirSeguro(idcliente,numero);
			
		}
		return "index.jsp";
	}

}
