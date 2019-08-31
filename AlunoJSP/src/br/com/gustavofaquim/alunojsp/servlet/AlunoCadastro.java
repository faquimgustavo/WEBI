package br.com.gustavofaquim.alunojsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gustavofaquim.alunojsp.dao.AlunoDAO;
import br.com.gustavofaquim.alunojsp.dao.CidadeDAO;
import br.com.gustavofaquim.alunojsp.model.Aluno;
import br.com.gustavofaquim.alunojsp.model.Cidade;

@WebServlet("/alunoCadastro")
public class AlunoCadastro extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String idad = req.getParameter("idade");
		String idcidade = req.getParameter("idCidade");
		int idCidade = Integer.parseInt(idcidade);
		int idade = Integer.parseInt(idad);
		
		Aluno a = new Aluno();
		a.setNome(nome);
		a.setIdade(idade);
	
		CidadeDAO cDAO = new CidadeDAO();

		a.setCidade(cDAO.pesquisaID(idCidade));
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(a);
		
		RequestDispatcher rd = req.getRequestDispatcher("/cadastroSucesso.jsp");
		rd.forward(req,resp);
		
	}
}
