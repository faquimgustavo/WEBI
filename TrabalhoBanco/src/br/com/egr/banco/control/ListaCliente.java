package br.com.egr.banco.control;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.model.PessoaFisica;
import br.com.lucasfaria.javawebcrud.dao.AlunoDao;
import br.com.lucasfaria.javawebcrud.model.Aluno;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ListaCliente implements Servidor {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PessoaFisica> listapf = new PessoaFisicaDAO.listarPF();
		List<Aluno> lista = new AlunoDao().listarTudo();
	}

}
