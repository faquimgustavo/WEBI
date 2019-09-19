package br.com.egr.banco.control;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.dao.PessoaJuridicaDAO;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.ContaPoupanca;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;
import br.com.egr.banco.model.Produto;


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
		
		if(pjDAO.verifica(idcliente)) {
			//Cliente c = new PessoaJuridica();
			//c = pjDAO.pesquisarId(idcliente);
			tipo = "PessoaJuridica";
		}
		
		else if(pfDAO.verifica(idcliente)) {
			//Cliente c = new PessoaFisica();
			//c = pfDAO.pesquisarId(idcliente);
			tipo = "PessoaFisica";
		}
		
		
		String nomeClasse = "br.com.egr.banco.model." + tipo;
		Class<?> cliente = Class.forName(nomeClasse);
		
		
		String classeNome = "br.com.egr.banco.model." + tipoProduto;
		Class<?> produto = Class.forName(classeNome);
		
		
		Produto produtos = (Produto) produto.getDeclaredConstructor().newInstance();
		// Como acessar um metodo através da classe generica.
		// preciso acessar o cliente.addCContaCorrente();
		
		
		/*if(produto.equals("contaPoupanca")) {
			ContaPoupanca cp = new ContaPoupanca(numero);
			c.addCPoupanca(cp.getNumero());
			
		}
		else if(produto.equals("contaCorrente")) {
			c.addCCorrente(numero);
		}
		else if(produto.equals("Seguro")) {
			Double valorSeguro = Double.parseDouble(req.getParameter("valorSeguro"));
			c.addSeguro(numero, valorSeguro);
		}*/
		
		
		return "index.jsp";
	} catch (Exception e) {
		throw new ServletException(e);
	}
	}
	
}
