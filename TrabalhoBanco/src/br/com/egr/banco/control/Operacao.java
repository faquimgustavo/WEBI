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
import br.com.egr.banco.model.Produto;
import br.com.egr.banco.model.Seguro;

public class Operacao implements Servidor{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	try {
		
		int numConta = Integer.parseInt(req.getParameter("idconta"));
		int numConta2 = Integer.parseInt(req.getParameter("idconta2"));
		String produto = req.getParameter("produto");
		double valor = Double.parseDouble(req.getParameter("valorOperacao"));

		ContaDAO contaDAO = new ContaDAO();
		Conta c = contaDAO.pesquisarNumero(numConta);
		Conta c2 = contaDAO.pesquisarNumero(numConta2);
		
		if (produto.equals("saque")) {
			
			if (c.getSaldo() >= valor) {
				
				c.sacar(valor);
				
			}
			
		}else if(produto.equals("deposito")) {
			
			c.depositar(valor);
			
		}else if(produto.equals("transferencia")) {
			
			if (c.getSaldo() >= valor) {
				
				c.sacar(valor);
				c2.depositar(valor);
			}	
			
		}
		
		contaDAO.atualizar(c);
		contaDAO.atualizar(c2);
					
		return "index.jsp";
	} catch (Exception e) {
		throw new ServletException(e);
	}
	}

}
