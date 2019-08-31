package br.com.gustavofaquim.alunojsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gustavofaquim.alunojsp.dao.AlunoDAO;
import br.com.gustavofaquim.alunojsp.model.Aluno;

@WebServlet("/alunoLista")
public class AlunoLista extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.listar();
		req.setAttribute("lista", lista);
		RequestDispatcher rd = req.getRequestDispatcher("lista/aluno.jsp");
		rd.forward(req, resp);
	}
}
