package br.com.gustavofaquim.alunojsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gustavofaquim.alunojsp.dao.CidadeDAO;
import br.com.gustavofaquim.alunojsp.model.Cidade;

@WebServlet("/cidadeCadastro")
public class CidadeCadastro extends HttpServlet  {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String nome = req.getParameter("nome");
	String estado = req.getParameter("estado");
	
	
	Cidade cidade = new Cidade();
	cidade.setNome(nome);
	cidade.setEstado(estado);
	
	
	CidadeDAO cidadeDAO = new CidadeDAO();
	cidadeDAO.inserir(cidade);
	
	RequestDispatcher rd = req.getRequestDispatcher("/cadastroSucesso.jsp");
	rd.forward(req,resp);
		
	}
}
