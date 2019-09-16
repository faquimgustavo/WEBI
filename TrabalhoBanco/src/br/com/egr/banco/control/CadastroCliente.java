package br.com.egr.banco.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.egr.banco.dao.ClienteDAO;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;

public class CadastroCliente implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String telefone = req.getParameter("telefone");
		String endereco = req.getParameter("endereco");
		String tipo = req.getParameter("tipo");
		System.out.println(tipo);
		
		
		if(tipo.equals("PessoaFisica")) {
			String cpf = req.getParameter("cpf");
			String nomeMae = req.getParameter("nomeMae");
			String nomePai = req.getParameter("nomePai");
			
			PessoaFisica pf = new PessoaFisica(nome,telefone,endereco,cpf,nomeMae,nomePai);
			// inserir o produto dentro do cliente
			
			//int id = new ClienteDAO().inserir(pf);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			int id = clienteDAO.inserir(pf);
			
			pf.setIdcliente(id);
			
			new PessoaFisicaDAO().inserir(pf);
			System.out.println(id);
			
		}
		else if(tipo == "PessoaJuridica") {
			String nomeFantasia = req.getParameter("nomeFantasia");
			String cnpj = req.getParameter("cnpj");
		
			PessoaJuridica pj =  new PessoaJuridica(nome, telefone, endereco, cnpj, nomeFantasia);
			// inserir o produto dentro do cliente
			new ClienteDAO().inserir(pj);
		}
		
		
		
		return "index.jsp";
	}

}
