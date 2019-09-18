package br.com.egr.banco.control;
import br.com.egr.banco.dao.ClienteDAO;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.dao.PessoaJuridicaDAO;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ListaCliente implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cliente> lista = new ClienteDAO().listarTudo();
		List<PessoaFisica> listapf = new PessoaFisicaDAO().listarPF();
		List<PessoaJuridica> listapj = new PessoaJuridicaDAO().listarPJ();
		
		
		req.setAttribute("lista", lista);
		req.setAttribute("listapf", listapf);
		req.setAttribute("listapj", listapj);
		return "listaCliente.jsp";
	}

}
