package br.com.gustavofaquim.alunojsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import br.com.gustavofaquim.alunojsp.dao.CidadeDAO;
import br.com.gustavofaquim.alunojsp.model.Cidade;

@WebServlet("/cidadeLista")
public class CidadeLista extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> lista = cidadeDAO.listar();
		
		req.setAttribute("lista", lista);
		RequestDispatcher rd = req.getRequestDispatcher("/listarCidades.jsp");
		rd.forward(req, resp);
	}
}
