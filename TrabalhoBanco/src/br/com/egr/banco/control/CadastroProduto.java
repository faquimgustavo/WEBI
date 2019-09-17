package br.com.egr.banco.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import br.com.egr.banco.dao.ClienteProdutoDAO;
import br.com.egr.banco.dao.ContaDAO;
import br.com.egr.banco.dao.SeguroDAO;
import br.com.egr.banco.model.ContaCorrente;
import br.com.egr.banco.model.Seguro;

public class CadastroProduto implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idcliente = Integer.parseInt(req.getParameter("idcliente"));
		String produto = req.getParameter("produto");
		
		if(produto.equals("contaCorrente") || produto.equals("contaPoupanca")) {
			
			// Gera um numero aleatorio que será usado para a conta.
			Random random = new Random();
			int numero = random.nextInt(1000);
			
			//ContaCorrente cc = new ContaCorrente(numero);
			
			ContaDAO contaDAO = new ContaDAO(); 
			contaDAO.inserir(numero, produto);
			
			ClienteProdutoDAO cpDAO = new ClienteProdutoDAO();
			//System.out.println(numero);
			cpDAO.inserirConta(idcliente, numero);
		}
		
		else if(produto.equals("Seguro")) {
			Random random = new Random();
			int numero = random.nextInt(1000);
			
			Seguro seguro = new Seguro(numero, 20.000);
			
			SeguroDAO seguroDAO = new SeguroDAO();
			seguroDAO.inserir(seguro);
			
			ClienteProdutoDAO cpDAO = new ClienteProdutoDAO();
			cpDAO.inserirSeguro(idcliente,numero);
			
		}
		return "index.jsp";
	}

}
